package com.soap.testpickerview.viewmodels;

import android.graphics.Color;

import androidx.databinding.Bindable;
import androidx.databinding.Observable;
import androidx.databinding.PropertyChangeRegistry;
import androidx.lifecycle.ViewModel;

import com.soap.testpickerview.BR;
import com.soap.testpickerview.models.BuildingModel;
import com.soap.testpickerview.models.FloorModel;
import com.soap.testpickerview.models.SpaceModel;
import com.wx.wheelview.widget.WheelView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainViewModel extends ViewModel implements Observable{
    private final PropertyChangeRegistry callbacks = new PropertyChangeRegistry();
    private final List<BuildingModel> buildings = Arrays.asList( new BuildingModel("1","25号楼"),
            new BuildingModel("2","20号楼") );
    private int selectBuildingIndex;
    private List<FloorModel> floorModels;
    private int selectFloorIndex;
    private List<SpaceModel> spaceModels;
    private int selectSpaceIndex = 1;
    private String title = "Reload";
    private final WheelView.WheelViewStyle style;

    public MainViewModel(){
        this.style = new WheelView.WheelViewStyle();
        style.textColor = Color.parseColor("#7C7C7D");
        style.selectedTextColor = Color.parseColor("#222222");
        style.textSize = 14;
        loadFloors();
        loadSpace();
    }

    @Override
    public void addOnPropertyChangedCallback(
            Observable.OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(
            Observable.OnPropertyChangedCallback callback) {
        callbacks.remove(callback);
    }

    /**
     * Notifies observers that a specific property has changed. The getter for the
     * property that changes should be marked with the @Bindable annotation to
     * generate a field in the BR class to be used as the fieldId parameter.
     *
     * @param fieldId The generated BR id for the Bindable field.
     */
    void notifyPropertyChanged(int fieldId) {
        callbacks.notifyCallbacks(this, fieldId, null);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BuildingModel> getBuildings() {
        return buildings;
    }

    @Bindable
    public List<FloorModel> getFloorModels() {
        return floorModels;
    }

    public void setFloorModels(List<FloorModel> floorModels) {
        this.floorModels = floorModels;
        this.notifyPropertyChanged(BR.floorModels);
    }

    @Bindable
    public List<SpaceModel> getSpaceModels() {
        return spaceModels;
    }

    public void setSpaceModels(List<SpaceModel> spaceModels) {
        this.spaceModels = spaceModels;
        this.notifyPropertyChanged(BR.spaceModels);
    }

    public WheelView.WheelViewStyle getStyle() {
        return style;
    }

    public void onSelectedBuilding( int index ){
        if( selectBuildingIndex != index ){
            selectBuildingIndex = index;
            selectFloorIndex = 0;
            selectSpaceIndex = 0;
            this.notifyPropertyChanged(BR.selectFloorIndex);
            this.notifyPropertyChanged(BR.selectSpaceIndex);
            loadFloors();
            loadSpace();

        }
    }

    public void onSelectedFloor( int index ){
        if( selectFloorIndex != index ){
            selectFloorIndex = index;
            selectSpaceIndex = 0;
            this.notifyPropertyChanged(BR.selectSpaceIndex);
            loadSpace();
        }
    }

    public void onSelectedSpace( int index ){
        if( selectSpaceIndex != index ){
            selectSpaceIndex = index;
        }
    }

    @Bindable
    public int getSelectBuildingIndex() {
        return selectBuildingIndex;
    }

    @Bindable
    public int getSelectFloorIndex() {
        return selectFloorIndex;
    }

    @Bindable
    public int getSelectSpaceIndex() {
        return selectSpaceIndex;
    }

    public void loadFloors(){
        List<FloorModel> floors = null;
        switch ( this.buildings.get(selectBuildingIndex).getId() ){
            case "1":
                floors = Arrays.asList( new FloorModel( "1" , "1楼" ),
                        new FloorModel( "2" , "2楼" ),
                        new FloorModel( "3" , "3楼" ),
                        new FloorModel( "4" , "4楼" ));
                break;
            case "2":
                floors = Collections.singletonList(new FloorModel("24", "24楼"));
                break;
        }
        setFloorModels(floors);
    }

    public void loadSpace(){
        List<SpaceModel> spaces = null;
        switch ( this.floorModels.get(selectFloorIndex).getId() ){
            case "1":
                spaces = Arrays.asList( new SpaceModel( "101" , "101会议室" ),
                                        new SpaceModel( "102" , "102中会议室" ),
                                        new SpaceModel( "103" , "103小会议室" ),
                                        new SpaceModel( "104" , "104吸烟室" ),
                                        new SpaceModel( "105" , "105修理室" ));
                break;
            case "2":
                spaces = Arrays.asList( new SpaceModel( "201" , "徐家汇" ),
                        new SpaceModel( "202" , "田子坊" ),
                        new SpaceModel( "203" , "新天地" ));
                break;
            case "3":
                spaces = Arrays.asList( new SpaceModel( "301" , "301会议室" ),
                                        new SpaceModel( "302" , "302中会议室" ),
                                        new SpaceModel( "303" , "303小会议室" ));
                break;
            case "4":
                spaces = Arrays.asList( new SpaceModel( "401" , "财务会议室" ),
                                        new SpaceModel( "402" , "人事会议室" ),
                                        new SpaceModel( "403" , "董事长会议室" ));
                break;
            case "24":
                spaces = Arrays.asList( new SpaceModel( "2401" , "茶水间" ),
                                        new SpaceModel( "2402" , "大会议室" ),
                                        new SpaceModel( "2403" , "中会议室" ));
                break;
        }
        setSpaceModels(spaces);
    }
}
