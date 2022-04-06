package com.soap.testpickerview;

import android.view.View;

import androidx.databinding.BindingAdapter;

import com.soap.testpickerview.models.BuildingModel;
import com.wx.wheelview.adapter.ArrayWheelAdapter;
import com.wx.wheelview.widget.WheelView;

import java.util.List;

public class WheelViewBindingAdapters {

    @BindingAdapter(value = {"itemsSource","style","onItemSelected","selectedIndex"},requireAll = false)
    public static <T> void setWheelViewItems(WheelView<T> wheelView , List<T> itemsSource,WheelView.WheelViewStyle style , WheelSelectListener onItemSelected , int selectedIndex){
        if( wheelView.getAdapter() == null ) {
            wheelView.setWheelAdapter(new ArrayWheelAdapter<>(wheelView.getContext()));
            wheelView.setSkin(WheelView.Skin.None);
            wheelView.setWheelSize(5);
            if (style != null) {
                wheelView.setStyle(style);
            }
        }
        if( wheelView.getWheelData() != itemsSource ) {
            wheelView.setWheelData(itemsSource);
        }
        if( onItemSelected != null ) {
            wheelView.setOnWheelItemSelectedListener((i, s) -> onItemSelected.onSelect(i));
        }
        if( wheelView.getCurrentPosition() != selectedIndex ) {
            wheelView.setSelection(selectedIndex);
        }
    }
}
