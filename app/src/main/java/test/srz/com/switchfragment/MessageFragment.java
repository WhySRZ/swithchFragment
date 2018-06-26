package test.srz.com.switchfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *  项目描述:消息
 *  作者: shenrunzhou 
 *  创建时间  :2018-06-25  9:42
 */

public class MessageFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        return View.inflate(getContext(), R.layout.fragment_message, null);
    }
}
