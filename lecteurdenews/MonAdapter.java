package com.dia.mous.lecteurdenews;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.oc.rss.fake.FakeNews;
import com.oc.rss.fake.FakeNewsList;

import java.util.List;

public class MonAdapter extends RecyclerView.Adapter<MonAdapter.MonViewHolder> {

    List<FakeNews> list = FakeNewsList.all;
    public static String strMonHtmlContent = "monHtmlContent";
    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MonViewHolder holder, int position) {
        FakeNews fn = list.get(position);
        holder.display(fn);
    }

    public class MonViewHolder extends RecyclerView.ViewHolder {

        private final TextView titre;
        private FakeNews currentFakeNews;
        private Context context = null;


        public MonViewHolder(final View itemView) {
            super(itemView);

            context = itemView.getContext();

            titre = ((TextView) itemView.findViewById(R.id.titre));

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Intent i = new Intent(context, WebViewActivity.class);
                    String[] tab = new String[] {currentFakeNews.title, currentFakeNews.htmlContent};
                    i.putExtra(strMonHtmlContent, tab);
                    context.startActivity(i);
                }
            });


        }

        public void display(FakeNews fn) {
            currentFakeNews = fn;
            titre.setText(currentFakeNews.title);
        }
    }


}
