package com.example.anonymous.sngregister;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

/**
 * Created by ANONYMOUS on 20-Jul-17.
 */

public class Adapter extends ArrayAdapter<Item> {
    public Adapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Item> objects) {
        super(context, resource, objects);
    }

    TextView name;
    CheckBox status;
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if(listItemView == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

         name = (TextView) listItemView.findViewById(R.id.name);
         status = (CheckBox) listItemView.findViewById(R.id.status);

        Item i = getItem(position);

        name.setText(i.getName());

        if (i.getStatus().equals("absent")) {
            status.setChecked(false);
        } else {
            status.setChecked(true);
        }

        status.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    changestatus("true");
                }
                else {
                    changestatus("true");

                }
            }
        });

        return listItemView;

    }
    public void changestatus(String str){

    }
}
