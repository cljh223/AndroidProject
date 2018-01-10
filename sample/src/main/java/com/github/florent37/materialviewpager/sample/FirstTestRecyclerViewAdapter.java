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
    ImageView radioImg1;
    ImageView ramenImg1;
    TextView ramenName;
    TextView district;
    TextView usage;
    TextView amount;

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
        radioImg1 = view.findViewById(R.id.radioImg1);
        ramenImg1 = view.findViewById(R.id.ramenImg1);
        ramenName = view.findViewById(R.id.ramenName1);
        district = view.findViewById(R.id.district1);
        usage = view.findViewById(R.id.usage1);
        amount = view.findViewById(R.id.amount1);


        /*라디오버튼1_1*/
        RadioButton btn11 = view.findViewById(R.id.logi_button11);
        btn11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg1.setImageResource(R.drawable.logi_11);
                ramenImg1.setImageResource(R.drawable.ansung_ramen);
                ramenName.setText("안성탕면");
                district.setText("A구역 / 30㎢");
                usage.setText("55%");
                amount.setText("338개");
            }
        });

        /*라디오버튼1_2*/
        RadioButton btn12 = view.findViewById(R.id.logi_button12);
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg1.setImageResource(R.drawable.logi_12);
                ramenImg1.setImageResource(R.drawable.sin_ramen);
                ramenName.setText("신라면");
                district.setText("B구역 / 45㎢");
                usage.setText("67%");
                amount.setText("412개");
            }
        });

        /*라디오버튼1_3*/
        RadioButton btn13 = view.findViewById(R.id.logi_button13);
        btn13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg1.setImageResource(R.drawable.logi_13);
                ramenImg1.setImageResource(R.drawable.nugool_ramen);
                ramenName.setText("너구리");
                district.setText("C구역 / 45㎢");
                usage.setText("71%");
                amount.setText("505개");
            }
        });

        /*라디오버튼1_4*/
        RadioButton btn14 = view.findViewById(R.id.logi_button14);
        btn14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg1.setImageResource(R.drawable.logi_14);
                ramenImg1.setImageResource(R.drawable.anchovy_ramen);
                ramenName.setText("멸치칼국수");
                district.setText("D구역 / 45㎢");
                usage.setText("80%");
                amount.setText("571개");
            }
        });

        /*라디오버튼1_5*/
        RadioButton btn15 = view.findViewById(R.id.logi_button15);
        btn15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg1.setImageResource(R.drawable.logi_15);
                ramenImg1.setImageResource(R.drawable.sari_ramen);
                ramenName.setText("사리곰탕");
                district.setText("E구역 / 45㎢");
                usage.setText("92%");
                amount.setText("603개");
            }
        });
    }

    public void progressBarChange(View view){
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar11 = (ProgressBar)view.findViewById(R.id.progressBar1_1);
        progressBar11.setProgress(55);
        ProgressBar progressBar12 = (ProgressBar)view.findViewById(R.id.progressBar1_2);
        progressBar12.setProgress(67);
        ProgressBar progressBar13 = (ProgressBar)view.findViewById(R.id.progressBar1_3);
        progressBar13.setProgress(71);
        ProgressBar progressBar14 = (ProgressBar)view.findViewById(R.id.progressBar1_4);
        progressBar14.setProgress(80);
        ProgressBar progressBar15 = (ProgressBar)view.findViewById(R.id.progressBar1_5);
        progressBar15.setProgress(92);

        /*ProgressBar 텍스트 변경*/
        TextView textView11 = (TextView)view.findViewById(R.id.index1_1);
        textView11.setText("55%");
        TextView textView12 = (TextView)view.findViewById(R.id.index1_2);
        textView12.setText("67%");
        TextView textView13 = (TextView)view.findViewById(R.id.index1_3);
        textView13.setText("71%");
        TextView textView14 = (TextView)view.findViewById(R.id.index1_4);
        textView14.setText("80%");
        TextView textView15 = (TextView)view.findViewById(R.id.index1_5);
        textView15.setText("92%");
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