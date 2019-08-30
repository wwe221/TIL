package org.techtown.drawer;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 *
 */

public class Fragment1 extends Fragment {
    Button bt;
    TextView tv;
    public FragmentCallback fc;
    @Override
    public void onAttach(Context context) {
        // fragment1 이 화면에 띄워질때 이를 호출한 reference 를 context 로 받아올수 있다.
        // 결과적으로 MainActivity 에서 Fragment1 을 호출한 것이기 때문에
        // context 가 MainActivity가 되고 , 이를 fc 로 받아서 메인에 선언된 함수를 사용할 수 있게 된다.
        super.onAttach(context);
        if(context instanceof FragmentCallback){
            fc = (FragmentCallback) context;
        }
    }
    @Nullable

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment1, container, false);
        bt = rootView.findViewById(R.id.button);
        tv=rootView.findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("change");
                fc.onFragmentSelected(2,null);
            }
        });
        return rootView;
    }

}
