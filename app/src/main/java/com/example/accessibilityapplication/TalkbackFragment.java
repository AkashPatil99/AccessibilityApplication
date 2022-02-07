package com.example.accessibilityapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.regex.Pattern;

public class TalkbackFragment extends Fragment {
    private int count = 0;
    private TextView searchString;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_talkback, container, false);
        View container_view = rootView.findViewById(R.id.container_3);
        final TextView counterDescriptionView = container_view.findViewById(R.id.counter_description);
        container_view.findViewById(R.id.counter).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                counterDescriptionView.setText(String.format("Replay %d times", ++count));
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchString = view.findViewById(R.id.googleLink);
//        Pattern pattern = Pattern.compile("Google");
//        String google = "http://www.google.com";
//        Linkify.addLinks(searchString, pattern, google);
//
//        SpannableStringBuilder spannableString = new SpannableStringBuilder("Search New Songs On Google.com");
//        String url = "http://www.google.com";
//        spannableString.setSpan(new URLSpan("http://www.google.com"), spannableString.toString().indexOf("Google.com"), spannableString.toString().length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//        searchString.setText(spannableString);

        searchString.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
