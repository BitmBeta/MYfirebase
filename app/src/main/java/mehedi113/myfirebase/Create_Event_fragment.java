package mehedi113.myfirebase;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Create_Event_fragment extends Fragment {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private ListView listView;
    private TextView showmessage;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;


    public Create_Event_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_create__event_fragment, container, false);

        showmessage= v.findViewById(R.id.emptyListMessage);
        drawerLayout= v.findViewById(R.id.mainnav);
        toggle = new ActionBarDrawerToggle(getActivity(),drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listView= v.findViewById(R.id.eventListView);



       //

        return v;
    }



}

/**



 @Override
 public boolean onOptionsItemSelected(MenuItem item) {

 if (toggle.onOptionsItemSelected(item)){
 return  true;
 }
 return super.onOptionsItemSelected(item);
 }

 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
 getMenuInflater().inflate(R.menu.meni2,menu);
 return super.onCreateOptionsMenu(menu);
 }


 public void addNewEvent(View view) {
 startActivity(new Intent( this,AddEvent.class));

 }
 **/