package com.soap.testpickerview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.soap.testpickerview.databinding.ActivityMainBinding;
import com.soap.testpickerview.models.BuildingModel;
import com.soap.testpickerview.viewmodels.MainViewModel;
import com.wx.wheelview.widget.WheelView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<BuildingModel> buildings = Arrays.asList( new BuildingModel("1","25号楼"),
            new BuildingModel("2","20号楼") );


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        MainViewModel viewModel = new ViewModelProvider(this)
                .get(MainViewModel.class);
        ActivityMainBinding binding  = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setDataContext( viewModel );
        //binding.wheelview.init();
        //binding.wheelFloor.init();
        //binding.wheelSpace.init();
        /*
        WheelView wheelView =  findViewById(R.id.wheelview);
        wheelView.setWheelAdapter(new ArrayWheelAdapter<>(this)); // 文本数据源
        wheelView.setSkin(WheelView.Skin.Holo); // common皮肤
        WheelView.WheelViewStyle style = new WheelView.WheelViewStyle();
        //style.backgroundColor = Color.YELLOW;
        style.textColor = Color.parseColor("#7C7C7D");
        style.selectedTextColor = Color.parseColor("#222222");
        style.textSize = 14;
        wheelView.setStyle(style);
        wheelView.setWheelData( buildings );

        wheelView.setOnWheelItemSelectedListener((i, s) -> {
            Toast toast = Toast.makeText(this.getBaseContext(), wheelView.getSelectionItem().getName() , Toast.LENGTH_SHORT);
            toast.show();
        });
         */

    }
}