package vn.edu.ntu.quangnghia.kiemtra1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class ThongBaoFragment extends Fragment {
   TextView HienThi;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        HienThi = view.findViewById(R.id.HienThi);
        HienThi.setText("Chức mừng khách hàng: "+DangKyFragment.edtName.getText().toString()
                +"\n"+"Sinh ngày: "+DangKyFragment.edtDate.getText().toString()+"\n"
                +"Đăng ký vào lúc: "+DangKyFragment.edtTime.getText().toString()+"\n"+
                "Hình thức thanh toán: "+DangKyFragment.phuongthucthanhtoan+"\n"+
                "Chúng tôi sẽ liên lạc với bạn theo số điện thoại: "+"\n"+DangKyFragment.edtSdt.getText().toString()+"\n"
                        +"Đã đăng ký thành công dịch vụ: "+"\n"
                +DangKyFragment.loaiDV);
        return view;
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThongBaoFragment.this)
                        .navigate(R.id.action_KetQuaFragment_to_DangKyFragment);
            }
        });
    }
}
