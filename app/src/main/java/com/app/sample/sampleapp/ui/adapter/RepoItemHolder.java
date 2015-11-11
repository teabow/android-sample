package com.app.sample.sampleapp.ui.adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.sample.sampleapp.R;
import com.app.sample.sampleapp.model.Repo;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import uk.co.ribot.easyadapter.ItemViewHolder;
import uk.co.ribot.easyadapter.PositionInfo;
import uk.co.ribot.easyadapter.annotations.LayoutId;
import uk.co.ribot.easyadapter.annotations.ViewId;

/**
 * Created by thibaud.bourgeois on 11/11/2015.
 * Repo recycler holder
 */
@LayoutId(R.layout.item_repo)
public class RepoItemHolder extends ItemViewHolder<Repo> {

    @ViewId(R.id.text_name)
    private TextView itemName;

    @ViewId(R.id.text_description)
    private TextView itemDescription;

    @ViewId(R.id.text_language)
    private TextView itemLanguage;

    @ViewId(R.id.image_avatar)
    private ImageView itemAvatar;

    public RepoItemHolder(View view) {
        super(view);
    }

    @Override
    public void onSetValues(Repo item, PositionInfo positionInfo) {
        itemName.setText(item.getName());
        itemDescription.setText(item.getDescription());
        String language = item.getLanguage();
        if (language != null) {
            itemLanguage.setText(String.format(getContext().getString(R.string.label_language), item.getLanguage()));
        }
        Picasso.with(getContext()).load(item.getOwner().getAvatar_url()).into(itemAvatar);
    }
}
