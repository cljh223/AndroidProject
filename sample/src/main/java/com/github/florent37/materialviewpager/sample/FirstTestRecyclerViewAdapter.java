package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

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
    ImageView radioImg;
    ImageView ramenImg;


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
                        Log.v("여기", "에서 작은카드 붙음");
                        /*Intent intent = new Intent(this, logi_SmallActivity.class);
                        startActivity(intent);*/
                        view.findViewById(R.id.logisticsFirstSmallLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsThirdSmallLayout).setVisibility(View.GONE);

                        /*뷰 이벤트 추가*/
                        progressBarChange(view);

                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstBigLayout).setVisibility(View.VISIBLE);
                        view.findViewById(R.id.logisticsSecondBigLayout).setVisibility(View.GONE);
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

    public void onRadioButtonClicked(View view){
        Log.v("하잇", "=======>여기로 들어옴");
        RadioGroup RG = view.findViewById(R.id.logi_radioGroup1);
        radioImg = view.findViewById(R.id.radioImg);
        ramenImg = view.findViewById(R.id.ramenImg);

        /*라디오버튼1_1*/
        RadioButton btn11 = view.findViewById(R.id.logi_button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg.setImageResource(R.drawable.logi_11);
                ramenImg.setImageResource(R.drawable.ansung_ramen);
            }
        });

        /*라디오버튼1_2*/
        RadioButton btn12 = view.findViewById(R.id.logi_button12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg.setImageResource(R.drawable.logi_12);
                ramenImg.setImageResource(R.drawable.sin_ramen);
            }
        });

        /*라디오버튼1_3*/
        RadioButton btn13 = view.findViewById(R.id.logi_button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg.setImageResource(R.drawable.logi_13);
                ramenImg.setImageResource(R.drawable.nugool_ramen);
            }
        });

        /*라디오버튼1_4*/
        RadioButton btn14 = view.findViewById(R.id.logi_button14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg.setImageResource(R.drawable.logi_14);
                ramenImg.setImageResource(R.drawable.anchovy_ramen);
            }
        });

        /*라디오버튼1_5*/
        RadioButton btn15 = view.findViewById(R.id.logi_button15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg.setImageResource(R.drawable.logi_15);
                ramenImg.setImageResource(R.drawable.sari_ramen);
            }
        });

    }

    public void progressBarChange(View view){
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar1 = (ProgressBar)view.findViewById(R.id.progressBar1_1);
        progressBar1.setProgress(50);
        ProgressBar progressBar2 = (ProgressBar)view.findViewById(R.id.progressBar1_2);
        progressBar2.setProgress(60);
        ProgressBar progressBar3 = (ProgressBar)view.findViewById(R.id.progressBar1_3);
        progressBar3.setProgress(70);
        ProgressBar progressBar4 = (ProgressBar)view.findViewById(R.id.progressBar1_4);
        progressBar4.setProgress(80);
        ProgressBar progressBar5 = (ProgressBar)view.findViewById(R.id.progressBar1_5);
        progressBar5.setProgress(90);

        TextView textView = (TextView)view.findViewById(R.id.index1_1);
        textView.setText("50%");
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