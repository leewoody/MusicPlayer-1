package com.ldt.musicr.recyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.ldt.musicr.MediaData.Song_OnLoad;
import com.ldt.musicr.R;

/**
 * Created by trung on 8/30/2017.
 */

public class chooseOneSong2MakeListAdapter extends RecyclerView.Adapter<chooseOneSong2MakeListAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Khai báo Icon, Tên bài hát,Tên nghệ sỹ
        public ImageView imageView;
        public TextView titleSong, artistSong;
        public RelativeLayout item_relative_root;

        public ViewHolder(View view) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(view);
            item_relative_root = (RelativeLayout) view;
            imageView = (ImageView) view.findViewById(R.id.album_art);
            titleSong = (TextView) view.findViewById(R.id.title_song_list);
            artistSong = (TextView) view.findViewById(R.id.artist_song_list);
        }

    }

    private java.util.List<Song_OnLoad> mSongs;
    // Store the context for easy access
    private Context mContext;

    // Pass in the contact array into the constructor
    public chooseOneSong2MakeListAdapter(Context context, java.util.List<Song_OnLoad> songs) {
        mSongs = songs;
        mContext = context;
    }

    // Easy access to the context object in the recyclerview
    private Context getContext() {
        return mContext;
    }

    @Override
    public chooseOneSong2MakeListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.item_rv_n1, parent, false);

        // Return a new holder instance
        chooseOneSong2MakeListAdapter.ViewHolder viewHolder = new chooseOneSong2MakeListAdapter.ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(chooseOneSong2MakeListAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on posTop
        Song_OnLoad this_song = mSongs.get(position);

        // Set item views based on your views and data model

        if (this_song.AlbumArt_path == "" || this_song.AlbumArt_path == null) {
            viewHolder.imageView.setImageResource(this_song.Id_Image);
        } else {
            // imageView.setImageResource(R.drawable.walle);
            Bitmap bm = BitmapFactory.decodeFile(this_song.AlbumArt_path);
            // if (id == dd) setBackground();
            viewHolder.imageView.setImageBitmap(bm);
        }
        viewHolder.titleSong.setText(this_song.Title);
        viewHolder.artistSong.setText(this_song.Artist);
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return mSongs.size();
    }


}