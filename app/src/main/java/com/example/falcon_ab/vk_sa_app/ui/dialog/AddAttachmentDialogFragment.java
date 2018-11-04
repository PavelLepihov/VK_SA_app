package com.example.falcon_ab.vk_sa_app.ui.dialog;

import android.Manifest;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import droidninja.filepicker.FilePickerBuilder;

public class AddAttachmentDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                    Manifest.permission.READ_EXTERNAL_STORAGE)) {
            } else {
                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        123);
            }
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Прикрепить")
                .setItems(new String[]{"Фото", "Документ"}, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        switch (i) {
                            case 0:
                                FilePickerBuilder
                                        .getInstance().setMaxCount(10)
                                        .showFolderView(false)
                                        .pickPhoto(getActivity());
                                break;
                            case 1:

                                FilePickerBuilder.getInstance().setMaxCount(10)
                                        .pickFile(getActivity());
                                break;
                        }
                    }
                });
        return builder.create();
    }
}
