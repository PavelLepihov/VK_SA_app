package com.example.falcon_ab.vk_sa_app.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.widget.Toast;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.example.falcon_ab.vk_sa_app.CurrentUser;
import com.example.falcon_ab.vk_sa_app.MyApplication;
import com.example.falcon_ab.vk_sa_app.R;
import com.example.falcon_ab.vk_sa_app.consts.ApiConstants;
import com.example.falcon_ab.vk_sa_app.model.Profile;
import com.example.falcon_ab.vk_sa_app.mvp.presenter.MainPresenter;
import com.example.falcon_ab.vk_sa_app.mvp.view.MainView;
import com.example.falcon_ab.vk_sa_app.rest.api.AccountApi;
import com.example.falcon_ab.vk_sa_app.rest.model.request.AccountRegisterDeviceRequest;
import com.example.falcon_ab.vk_sa_app.ui.fragment.BaseFragment;
import com.example.falcon_ab.vk_sa_app.ui.fragment.NewsFeedFragment;
import com.mikepenz.google_material_typeface_library.GoogleMaterial;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileSettingDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKError;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends BaseActivity implements MainView {

    @InjectPresenter
    MainPresenter mPresenter;

    @Inject
    AccountApi mAccountApi;

    private Drawer mDrawer;

    private AccountHeader mAccountHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.getApplicationComponent().inject(this);

        mPresenter.checkAuth();
    }

    public void setUpDrawer() {
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.screen_name_feed)
                .withIcon(GoogleMaterial.Icon.gmd_home);

        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName(R.string.screen_name_my_posts)
                .withIcon(GoogleMaterial.Icon.gmd_list);

        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName(R.string.screen_name_settings)
                .withIcon(GoogleMaterial.Icon.gmd_settings);

        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName(R.string.screen_name_members)
                .withIcon(GoogleMaterial.Icon.gmd_people);

        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName(R.string.screen_name_topics)
                .withIcon(GoogleMaterial.Icon.gmd_record_voice_over);

        PrimaryDrawerItem item6 = new PrimaryDrawerItem().withIdentifier(6).withName(R.string.screen_name_info)
                .withIcon(GoogleMaterial.Icon.gmd_info);

        PrimaryDrawerItem item7 = new PrimaryDrawerItem().withIdentifier(7).withName(R.string.screen_name_rules)
                .withIcon(GoogleMaterial.Icon.gmd_assignment);
        mAccountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .build();
        mDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(true)
                .withAccountHeader(mAccountHeader)
                .addDrawerItems(item1, item2, item3,
                        new SectionDrawerItem().withName("Группа"),
                        item4, item5, item6, item7)
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    mPresenter.drawerItemClick((int) drawerItem.getIdentifier());
                    return false;
                })
                .build();
    }

    @Override
    protected int getMainContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
            // Пользователь успешно авторизовался
                mPresenter.checkAuth();
            }
            @Override
            public void onError(VKError error) {
            // Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void startSignIn() {
        VKSdk.login(this, ApiConstants.DEFAULT_LOGIN_SCOPE);
    }

    @Override
    public void signedId() {
        Toast.makeText(this, "Current user id: " + CurrentUser.getId(), Toast.LENGTH_SHORT).show();
        setContent(new NewsFeedFragment());
        setUpDrawer();
        mAccountApi.registerDevice(new AccountRegisterDeviceRequest(Settings.Secure.getString(getContentResolver(),
                Settings.Secure.ANDROID_ID)).toMap())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

    @Override
    public void showCurrentUser(Profile profile) {
        List<IProfile> profileDrawerItems = new ArrayList<>();
        profileDrawerItems.add(new ProfileDrawerItem().withName(profile.getFullName())
                .withEmail(VKAccessToken.currentToken().email)
                .withIcon(profile.getDisplayProfilePhoto()));

        profileDrawerItems.add(new ProfileSettingDrawerItem().withName("Logout")
                .withOnDrawerItemClickListener((view, position, drawerItem) -> {
                    mAccountHeader.removeProfile(0);
                    mAccountHeader.removeProfile(0);
                    VKSdk.logout();
                    return false;
                }));
        mAccountHeader.setProfiles(profileDrawerItems);
    }

    @Override
    public void showFragmentFromDrawer(BaseFragment baseFragment) {
        setContent(baseFragment);
    }

    @Override
    public void startActivityFromDrawer(Class<?> act) {
        startActivity(new Intent(MainActivity.this, act));
    }
}
