package com.example.databasedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameEditText,rollEditText,addressEditText,mobileEditText;
    Spinner departmentSpinner,shiftSpinner;
    String name,roll,address,shift,department,mobile;
    Button insertButton,displayButton,updateButton,deleteButton;
    DataBaseHelper dataBaseHelper;
    String []departmentList,shiftList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameEditText=findViewById(R.id.nameTextViewId);
        rollEditText=findViewById(R.id.rollTextViewId);
        addressEditText=findViewById(R.id.addressTextViewId);
        shiftSpinner=findViewById(R.id.shiftSpinnerId);
        departmentSpinner=findViewById(R.id.departmentSpinnerId);
        mobileEditText=findViewById(R.id.mobileTextViewId);

        insertButton=findViewById(R.id.insertDataButtonId);
        displayButton=findViewById(R.id.displayDataButtonId);
        updateButton=findViewById(R.id.updateDataButtonId);
        deleteButton=findViewById(R.id.deleteDataButtonId);
        //arrayList
        departmentList=getResources().getStringArray(R.array.department);
        shiftList=getResources().getStringArray(R.array.shift);

        insertButton.setOnClickListener(this);
        displayButton.setOnClickListener(this);
        updateButton.setOnClickListener(this);
        deleteButton.setOnClickListener(this);

        dataBaseHelper=new DataBaseHelper(this);
        SQLiteDatabase sqLiteDatabase=dataBaseHelper.getWritableDatabase();

        //for department spinner
        ArrayAdapter<String>departmentAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.sample_textview,R.id.sampleTextViewId,departmentList);
        departmentSpinner.setAdapter(departmentAdapter);

        //for department spinner
        ArrayAdapter<String>shiftAdapter=new ArrayAdapter<>(MainActivity.this,R.layout.sample_textview,R.id.sampleTextViewId,shiftList);
        shiftSpinner.setAdapter(shiftAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.insertDataButtonId){

            name=nameEditText.getText().toString();
            roll=rollEditText.getText().toString();
            address=addressEditText.getText().toString();
           //shift=shiftEditText.getText().toString();

            //department=departmentSpinner.getText().toString();
            mobile=mobileEditText.getText().toString();
            shift=shiftSpinner.getSelectedItem().toString();
            department=departmentSpinner.getSelectedItem().toString();

           long id= dataBaseHelper.insertData(name,roll,address,shift,department,mobile);
            Toast.makeText(this, String.valueOf(id), Toast.LENGTH_SHORT).show();


        }
        if (v.getId()==R.id.displayDataButtonId){
            Toast.makeText(this, "Display Button Clicked", Toast.LENGTH_SHORT).show();

        }
        if (v.getId()==R.id.updateDataButtonId){
            Toast.makeText(this, "Update Button Clicked", Toast.LENGTH_SHORT).show();
        }
        if (v.getId()==R.id.deleteDataButtonId){
            Toast.makeText(this, "Delete Button Clicked", Toast.LENGTH_SHORT).show();
        }
    }
}
