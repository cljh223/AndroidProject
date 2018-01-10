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
public class ThirdTestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    TextView textView;
    String jsontext;
    ProgressDialog progressDialog;
    ImageView radioImg3;
    ImageView ramenImg3;
    TextView ramenName;
    TextView district;
    TextView usage;
    TextView amount;

    public ThirdTestRecyclerViewAdapter(List<Object> contents) {
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
                        view.findViewById(R.id.purchaseSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseThirdSmallLayout).setVisibility(View.VISIBLE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_purchase, parent, false);
                        view.findViewById(R.id.purchaseFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.purchaseThirdBigLayout).setVisibility(View.VISIBLE);
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
                        view.findViewById(R.id.productionSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionThirdSmallLayout).setVisibility(View.VISIBLE);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_production, parent, false);
                        view.findViewById(R.id.productionFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.productionThirdBigLayout).setVisibility(View.VISIBLE);
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
                        view.findViewById(R.id.logisticsSecondSmallLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsThirdSmallLayout).setVisibility(View.VISIBLE);

                        /*뷰 이벤트 추가*/
                        progressBarChange(view);
                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_logistics, parent, false);
                        view.findViewById(R.id.logisticsFirstBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.logisticsThirdBigLayout).setVisibility(View.VISIBLE);

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
                        view.findViewById(R.id.salesSecondBigLayout).setVisibility(View.GONE);
                        view.findViewById(R.id.salesThirdBigLayout).setVisibility(View.VISIBLE);
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
        radioImg3 = view.findViewById(R.id.radioImg3);
        ramenImg3 = view.findViewById(R.id.ramenImg3);
        ramenName = view.findViewById(R.id.ramenName3);
        district = view.findViewById(R.id.district3);
        usage = view.findViewById(R.id.usage3);
        amount = view.findViewById(R.id.amount3);

        /*라디오버튼3_1*/
        RadioButton btn31 = view.findViewById(R.id.logi_button31);
        btn31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg3.setImageResource(R.drawable.logi_31);
                ramenImg3.setImageResource(R.drawable.ansung_ramen);
                ramenName.setText("안성탕면");
                district.setText("A구역 / 60㎢");
                usage.setText("76%");
                amount.setText("565개");
            }
        });

        /*라디오버튼3_2*/
        RadioButton btn32 = view.findViewById(R.id.logi_button32);
        btn32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg3.setImageResource(R.drawable.logi_32);
                ramenImg3.setImageResource(R.drawable.sin_ramen);
                ramenName.setText("신라면");
                district.setText("B구역 / 60㎢");
                usage.setText("55%");
                amount.setText("338개");
            }
        });

        /*라디오버튼3_3*/
        RadioButton btn33 = view.findViewById(R.id.logi_button33);
        btn33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg3.setImageResource(R.drawable.logi_33);
                ramenImg3.setImageResource(R.drawable.nugool_ramen);
                ramenName.setText("너구리");
                district.setText("C구역 / 30㎢");
                usage.setText("69%");
                amount.setText("429개");
            }
        });

        /*라디오버튼3_4*/
        RadioButton btn34 = view.findViewById(R.id.logi_button34);
        btn34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg3.setImageResource(R.drawable.logi_34);
                ramenImg3.setImageResource(R.drawable.anchovy_ramen);
                ramenName.setText("멸치칼국수");
                district.setText("D구역 / 60㎢");
                usage.setText("80%");
                amount.setText("571개");
            }
        });

        /*라디오버튼3_5*/
        RadioButton btn35 = view.findViewById(R.id.logi_button35);
        btn35.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioImg3.setImageResource(R.drawable.logi_35);
                ramenImg3.setImageResource(R.drawable.sari_ramen);
                ramenName.setText("사리곰탕");
                district.setText("E구역 / 60㎢");
                usage.setText("93%");
                amount.setText("612개");
            }
        });
    }

    public void progressBarChange(View view){
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar31 = (ProgressBar)view.findViewById(R.id.progressBar3_1);
        progressBar31.setProgress(76);
        ProgressBar progressBar32 = (ProgressBar)view.findViewById(R.id.progressBar3_2);
        progressBar32.setProgress(55);
        ProgressBar progressBar33 = (ProgressBar)view.findViewById(R.id.progressBar3_3);
        progressBar33.setProgress(69);
        ProgressBar progressBar34 = (ProgressBar)view.findViewById(R.id.progressBar3_4);
        progressBar34.setProgress(80);
        ProgressBar progressBar35 = (ProgressBar)view.findViewById(R.id.progressBar3_5);
        progressBar35.setProgress(93);

        /*ProgressBar 텍스트 변경*/
        TextView textView31 = (TextView)view.findViewById(R.id.index3_1);
        textView31.setText("76%");
        TextView textView32 = (TextView)view.findViewById(R.id.index3_2);
        textView32.setText("55%");
        TextView textView33 = (TextView)view.findViewById(R.id.index3_3);
        textView33.setText("69%");
        TextView textView34 = (TextView)view.findViewById(R.id.index3_4);
        textView34.setText("80%");
        TextView textView35 = (TextView)view.findViewById(R.id.index3_5);
        textView35.setText("93%");
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