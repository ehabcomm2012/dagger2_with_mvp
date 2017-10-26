package com.example.ehab.dagger2withmvp.helpers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;


public class DialogsHelper {

    public  AlertDialog getAlert(Activity activity, String title, String message, String okButton, String noButton, DialogInterface.OnClickListener onNegativeClickListner, DialogInterface.OnClickListener onPositiveClickListner) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(title).setMessage(message);
        dialog.setPositiveButton(okButton, onPositiveClickListner);
        if(!noButton.equals(""))
            dialog.setNegativeButton(noButton,onNegativeClickListner)  ;

        dialog.setCancelable(false);
        return dialog.create();
    }

    public  ProgressDialog getProgressDialog(Activity activity, String title, boolean cancelable, boolean CanceledOnTouchOutside) {
        ProgressDialog dialog = new ProgressDialog(activity);
        dialog.setMessage(title);
        //dialog.setIcon(R.mipmap.ic_launcher);
        dialog.setCancelable(cancelable);
        dialog.setCanceledOnTouchOutside(CanceledOnTouchOutside);
        return dialog;
    }

    public  AlertDialog getListDialog(Activity activity, String title, int ItemsId, DialogInterface.OnClickListener onItemClickListner){
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(title);
        dialog.setItems(ItemsId, onItemClickListner);
        dialog.setCancelable(true);
        return dialog.create();
    }



}
