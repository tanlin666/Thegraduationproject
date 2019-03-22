package com.tlandhmy.bueatifullife.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.tlandhmy.bueatifullife.R;

import androidx.navigation.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {


    @BindView(R.id.touxiang)
    CircleImageView touxiang;
    @BindView(R.id.et_phonenumber)
    EditText etPhonenumber;
    @BindView(R.id.et_password)
    EditText etPassword;
    Unbinder unbinder;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
        // Navigation.findNavController(view).navigate(R.id.action_livedata_fragment_to_livedata2_fragment)
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.tv_register, R.id.tv_forgetpassword})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_register:
                 Navigation.findNavController(view).navigate(R.id.action_login_to_register);
                break;
            case R.id.tv_forgetpassword:
                Navigation.findNavController(view).navigate(R.id.action_login_to_forgetpassword);
                break;
        }
    }
}
