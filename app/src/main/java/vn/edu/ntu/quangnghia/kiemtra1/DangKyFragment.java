package vn.edu.ntu.quangnghia.kiemtra1;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Calendar;


public class DangKyFragment extends Fragment {

    public static EditText edtName,edtDate, edtSdt, edtDiachi,edtTime;
    RadioGroup rdG;
    RadioButton rbdTM,rbdVI,rbdNH;
    Button btDK;
    ImageView date, time;
    Spinner SpinerDanhsach;
    public static String phuongthucthanhtoan;
    String arrayDichvu[] = {
            "Truyền hình cáp",
            "Internet",
            "Tivi",
            "Youtube",
            "Super vip",
            "Cáp quang"};

    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_first, container, false);
        // Inflate the layout for this fragment

    }

    private void setview1(View view) {
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               setngay();
            }
        });

    }


    public static String loaiDV;
    private void addviews(View view) {
        edtName = view.findViewById(R.id.edtName);
        edtDate = view.findViewById(R.id.edtDate);
        edtSdt = view.findViewById(R.id.edtSdt);
        edtDiachi = view.findViewById(R.id.edtDiaChi);
        edtTime = view.findViewById(R.id.edtTime);
        date = view.findViewById(R.id.date);
        time = view.findViewById(R.id.time);

        rdG = view.findViewById(R.id.rdG);

        rbdTM = view.findViewById(R.id.rdbTM);
        rbdNH = view.findViewById(R.id.rdbNH);
        rbdVI = view.findViewById(R.id.rdbVI);

        btDK = view.findViewById(R.id.btDK);

        SpinerDanhsach = (Spinner) view.findViewById(R.id.Spiner1);

        adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, arrayDichvu);

        SpinerDanhsach.setAdapter(adapter);
        SpinerDanhsach.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loaiDV = arrayDichvu[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setngay()
    {
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog.OnDateSetListener setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                StringBuilder builder = new StringBuilder();
                builder.append(dayOfMonth)
                        .append("/")
                        .append(month+1)
                        .append("/")
                        .append(year);
                edtDate.setText(builder.toString());
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), setListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH+1),calendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }
    private void setgio() {
        Calendar calendar = Calendar.getInstance();
        TimePickerDialog.OnTimeSetListener setListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                StringBuilder builder = new StringBuilder();
                builder.append(hourOfDay)
                        .append(":")
                        .append(minute);
                edtTime.setText(builder.toString());
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), setListener,calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE),true);
        timePickerDialog.show();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        addviews(view);
        setview1(view);
        setview2(view);

        view.findViewById(R.id.btDK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(DangKyFragment.this)
                        .navigate(R.id.action_DangKyFragment_to_KetQuaFragment);
                switch (rdG.getCheckedRadioButtonId())
                {
                    case R.id.rdbTM : phuongthucthanhtoan= "Tiền mặt";break;
                    case R.id.rdbNH : phuongthucthanhtoan= "Ngân hàng";break;
                    case R.id.rdbVI : phuongthucthanhtoan= "Ví điện tử";break;
                }
            }
        });
    }

    private void setview2(View view) {
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setgio();
            }
        });
    }

}
