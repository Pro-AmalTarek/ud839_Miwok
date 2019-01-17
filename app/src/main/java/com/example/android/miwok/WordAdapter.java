package com.example.android.miwok;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {

    public WordAdapter(Context context, ArrayList<Word> words){
        super(context, 0, words);
    }
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        if(convertView == null)
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        Word currentWord = getItem(position);

        TextView miwokTxt = convertView.findViewById(R.id.miwok_text_view);
        miwokTxt.setText(currentWord.getMiwokTranslation());

        TextView englishTxt = convertView.findViewById(R.id.default_text_view);
        englishTxt.setText(currentWord.getDefaultTranslation());
        // Check if an image is provided for this word or not
        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) convertView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentWord.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        return convertView;
    }
}
