package mehedi113.myfirebase;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSignUp extends Fragment {
    private EditText emailr, passr;
    android.support.v4.app.FragmentManager fm;
    android.support.v4.app.FragmentTransaction ft;
    FirebaseUser firebaseUser;
    FirebaseAuth firebaseAuth;



    public FragmentSignUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_fragment_sign_up, container, false);;
        emailr = v.findViewById(R.id.editText2);
        Button btnReg = v.findViewById(R.id.button);
        passr = v.findViewById(R.id.editText3);
       // t = v.findViewById(R.id.fragTv);
        firebaseAuth = FirebaseAuth.getInstance();





        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = emailr.getText().toString();
                String p = passr.getText().toString();
             //   t.setText(e+"-"+p);
                Task<AuthResult> task = firebaseAuth.createUserWithEmailAndPassword(e,p);

                task.addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            firebaseUser = firebaseAuth.getCurrentUser();
                           // t.setText("email id is registered" + firebaseUser.getEmail());
                            Toast.makeText(getActivity(), firebaseUser.getEmail() +" Email id is registered ", Toast.LENGTH_SHORT).show();

                            fm = getActivity().getSupportFragmentManager();;
                            ft = fm.beginTransaction();
                            Create_Event_fragment fragmentSignUp = new Create_Event_fragment();

                            ft.replace(R.id.fragmentContainer, fragmentSignUp);
                            ft.addToBackStack(null);
                            ft.commit();
                        }
                    }
                });
                task.addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                      //  t.setText(e.getMessage());
                        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

/*



*/

        return v;
    }

}
