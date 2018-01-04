package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class FirstTestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    TextView textView;
    String jsontext;
    ProgressDialog progressDialog;

    public FirstTestRecyclerViewAdapter(List<Object> contents) {
        this.contents = contents;
    }

    @Override
    public int getItemViewType(int position) {
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = null;
        switch (MainActivity.WHERE) {
            case "purchase":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.purchaseSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.purchaseSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "production":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_production, parent, false);
                        view.findViewById(R.id.productionFirstSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.productionSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_production, parent, false);
                        view.findViewById(R.id.productionFirstBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.productionSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "logistics":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "sales":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_sales, parent, false);
                        view.findViewById(R.id.salesFirstSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.salesSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_sales, parent, false);
                        view.findViewById(R.id.salesFirstBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.salesSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesThirdBigLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }


                return new RecyclerView.ViewHolder(view) {
                };
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }

}