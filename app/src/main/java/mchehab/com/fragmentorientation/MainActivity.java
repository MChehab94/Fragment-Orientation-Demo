package mchehab.com.fragmentorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

public class MainActivity extends AppCompatActivity {

    private PersonFragment personFragment = new PersonFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            Person person = new Person("first name", "last name", 20);
            Bundle bundle = new Bundle();
            bundle.putParcelable("person", Parcels.wrap(person));
            personFragment.setArguments(bundle);
            getFragmentManager().beginTransaction().add(R.id.frameLayout, personFragment).commit();
        }
    }
}
