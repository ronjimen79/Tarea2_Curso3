package com.ronicode.tarea2_curso3;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by Roni on 25/04/2017.
 */

public class Calendario extends DialogFragment
        implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMontth = c.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, dayOfMontth);

    }
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        TextView tv1 = (TextView) getActivity().findViewById(R.id.tvFecha);
        tv1.setText(view.getDayOfMonth() + "-" + view.getMonth() + "-" + view.getYear());
    }
}
