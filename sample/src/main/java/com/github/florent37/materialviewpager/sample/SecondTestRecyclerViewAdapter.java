package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class SecondTestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    TextView textView;
    String jsontext;
    ProgressDialog progressDialog;
    ImageView radioImg2;
    ImageView ramenImg2;

    public SecondTestRecyclerViewAdapter(List<Object> contents) {
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
                        view.findViewById(R.id.purchaseFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.purchaseThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseSecondBigLayout).setVisibility(View.VISIBLE);
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
                        view.findViewById(R.id.productionFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.productionThirdSmallLayout).setVisibility(View.GONE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_production, parent, false);
                        view.findViewById(R.id.productionFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionSecondBigLayout).setVisibility(View.VISIBLE);
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
                        view.findViewById(R.id.logisticsFirstSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsSecondSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsThirdSmallLayout).setVisibility(View.GONE);

                        /*뷰 이벤트 추가*/
                        progressBarChange(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsSecondBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsThirdBigLayout).setVisibility(View.GONE);

                        /*라디오버튼 이벤트 추가*/
                        onRadioButtonClicked(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                }
            case "sales":
                switch (viewType) {
                    case TYPE_HEADER: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_small_sales, parent, false);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_sales, parent, false);
                        view.findViewById(R.id.salesFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesSecondBigLayout).setVisibility(View.VISIBLE);
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

    public void onRadioButtonClicked(View view){
        radioImg2 = view.findViewById(R.id.radioImg2);
        ramenImg2 = view.findViewById(R.id.ramenImg2);

        /*라디오버튼2_1*/
        RadioButton btn21 = view.findViewById(R.id.logi_button21);
        btn21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_21);
                ramenImg2.setImageResource(R.drawable.ansung_ramen);
            }
        });

        //*라디오버튼2_2*/
        RadioButton btn22 = view.findViewById(R.id.logi_button22);
        btn22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_22);
                ramenImg2.setImageResource(R.drawable.sin_ramen);
            }
        });

        /*라디오버튼2_3*/
        RadioButton btn23 = view.findViewById(R.id.logi_button23);
        btn23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_23);
                ramenImg2.setImageResource(R.drawable.nugool_ramen);
            }
        });

        /*라디오버튼2_4*/
        RadioButton btn24 = view.findViewById(R.id.logi_button24);
        btn24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_24);
                ramenImg2.setImageResource(R.drawable.anchovy_ramen);
            }
        });

        /*라디오버튼2_5*/
        RadioButton btn25 = view.findViewById(R.id.logi_button25);
        btn25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg2.setImageResource(R.drawable.logi_25);
                ramenImg2.setImageResource(R.drawable.sari_ramen);
            }
        });
    }

    public void progressBarChange(View view){
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar1 = (ProgressBar)view.findViewById(R.id.progressBar2_1);
        progressBar1.setProgress(60);
        ProgressBar progressBar2 = (ProgressBar)view.findViewById(R.id.progressBar2_2);
        progressBar2.setProgress(50);
        ProgressBar progressBar3 = (ProgressBar)view.findViewById(R.id.progressBar2_3);
        progressBar3.setProgress(70);
        ProgressBar progressBar4 = (ProgressBar)view.findViewById(R.id.progressBar2_4);
        progressBar4.setProgress(90);
        ProgressBar progressBar5 = (ProgressBar)view.findViewById(R.id.progressBar2_5);
        progressBar5.setProgress(80);

        TextView textView = (TextView)view.findViewById(R.id.index2_1);
        textView.setText("60%");
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

