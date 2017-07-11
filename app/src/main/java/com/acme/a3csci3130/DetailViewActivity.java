/* July.10/2017 Robert Thomas B00618996
 * the detail view activity will open up when a contact is selected from the list that is populated from the main activity.
 * This was made from the example gitHub repository that was provided.
 * The Update and Delete Contact methods were added
 * @Update is the replacing of information for a uID with the info given
 * @Delete is to remove the entry at a given uID
 *
 * */

package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private EditText numberField, nameField, primBusField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;
    boolean updated = false, deleted = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        updated = false;
        deleted = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primBusField = (EditText) findViewById(R.id.primBus);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){

            numberField.setText(receivedPersonInfo.number);
            nameField.setText(receivedPersonInfo.name);
            primBusField.setText(receivedPersonInfo.primBus);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    //@update
    public void updateContact(View v){
        //TODO: Update contact funcionality
        appState = ((MyApplicationData) getApplicationContext());

        String personID = appState.firebaseReference.push().getKey();
        String number = numberField.getText().toString();
        String name = nameField.getText().toString();
        String primBus = primBusField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Contact person = new Contact(personID, number, name, primBus, address, province);

        appState.firebaseReference.child(personID).setValue(person);

        finish();
        updated = true;
    }
    //@delete
    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        appState = ((MyApplicationData) getApplicationContext());
        String personID = appState.firebaseReference.push().getKey();
        appState.firebaseReference.child(personID).removeValue();
        finish();
        deleted = true;
    }
}
