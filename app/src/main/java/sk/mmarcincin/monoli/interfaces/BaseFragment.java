package sk.mmarcincin.monoli.interfaces;

public interface BaseFragment {

    public default boolean onBackPressed(){
        return false;
    };

}
