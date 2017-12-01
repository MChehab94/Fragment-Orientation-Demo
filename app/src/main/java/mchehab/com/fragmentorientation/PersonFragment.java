package mchehab.com.fragmentorientation;

import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import org.parceler.Parcels;

public class PersonFragment extends Fragment {

    private Person person;
    private EditText editTextFirstName;
    private EditText editTextLastName;
    private EditText editTextAge;

    public PersonFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            Log.d("onCreate","instance not null");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_person, container, false);
        if(savedInstanceState != null){
            person = Parcels.unwrap(savedInstanceState.getParcelable("person"));
        }else{
            getPersonArguments();
        }

        editTextFirstName = view.findViewById(R.id.editTextFirstName);
        editTextLastName = view.findViewById(R.id.editTextLastName);
        editTextAge = view.findViewById(R.id.editTextAge);

        editTextFirstName.setText(person.getFirstName());
        editTextLastName.setText(person.getLastName());
        editTextAge.setText(person.getAge() + "");

        return view;
    }

    private void getPersonArguments(){
        Bundle bundle = getArguments();
        if(bundle != null){
            person = Parcels.unwrap(bundle.getParcelable("person"));
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("person", Parcels.wrap(person));
    }
}