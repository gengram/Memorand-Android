package com.example.memorand.perfil;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.memorand.R;

import java.util.ArrayList;

public class ProfileAdapter extends ArrayAdapter<ProfileItem> {

    public ProfileAdapter(Context context, ArrayList<ProfileItem> profileItems) {
        super(context, 0, profileItems);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ProfileItem profileItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_profile, parent, false);
        }

        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView emailTextView = convertView.findViewById(R.id.emailTextView);
        TextView statusTextView = convertView.findViewById(R.id.statusTextView);
        Button resetPasswordButton = convertView.findViewById(R.id.resetPasswordButton);
        Button editProfileButton = convertView.findViewById(R.id.editProfileButton);

        if (profileItem != null) {
            nameTextView.setText(profileItem.getName());
            emailTextView.setText(profileItem.getEmail());
            statusTextView.setText(profileItem.getStatus());
        }

        // Aquí puedes configurar los clics de los botones si es necesario

        return convertView;
    }

}
