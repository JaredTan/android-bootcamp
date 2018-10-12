package com.uber.jaredtan.beatbox;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uber.jaredtan.beatbox.databinding.FragmentBeatBoxBinding;
import com.uber.jaredtan.beatbox.databinding.ListItemSoundBinding;

public class BeatBoxFragment extends Fragment {
    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }

//    auto genned the fragmentBeatBoxBinding, which will bind on top of the recycler view with access to the parent view
//     no need to write findViewById
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentBeatBoxBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_beat_box, container, false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
//        hook up the sound adapter onCreateView;
        binding.recyclerView.setAdapter(new SoundAdapter());
        return binding.getRoot();
    }

    private class SoundHolder extends RecyclerView.ViewHolder {
        private ListItemSoundBinding mBinding;
//        this sound holder now will expect the implicitly generated list item sound binding
        private SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {
        @Override
        public int getItemCount() {
            return 0;
        }

        @Override
        public void onBindViewHolder(@NonNull SoundHolder soundHolder, int i) {

        }

        @NonNull
        @Override
        public SoundHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//            create the inflater
            LayoutInflater inflater = LayoutInflater.from(getActivity());
//            obtain the binding
            ListItemSoundBinding soundBinding = DataBindingUtil.inflate(inflater, R.layout.list_item_sound, viewGroup, false);
//            initialize the sound holder with the binding
            return new SoundHolder(soundBinding);
        }
    }
}
