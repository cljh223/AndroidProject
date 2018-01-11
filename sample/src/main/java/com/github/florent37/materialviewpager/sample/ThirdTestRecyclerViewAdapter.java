package com.github.florent37.materialviewpager.sample;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class ThirdTestRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Object> contents;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    static String shopWhere = new FirstTestRecyclerViewAdapter().shopWhere;
    View view2 = null;

    TextView textView;
    String jsontext;
    ProgressDialog progressDialog;
    ImageView radioImg3;
    ImageView ramenImg3;
    TextView ramenName;
    TextView district;
    TextView usage;
    TextView amount;

    //생산 부문 멤버
    LinearLayout resultlayout;
    TextView r_name;
    TextView r_param;
    TextView r_amount;
    TextView notify;
    String spinnerResult;
    String radioResult;
    String amountResult;
    RadioGroup rg;
    RadioButton rb;
    EditText editText;
    RadioButton rb1;
    RadioButton rb2;
    RadioButton rb3;

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

                        SpinnerSet(view);
                        RadioGet(view);
                        r_name = view.findViewById(R.id.notify1);
                        r_param = view.findViewById(R.id.notify2);
                        r_amount = view.findViewById(R.id.notify3);
                        notify = view.findViewById(R.id.notify4);
                        editText = view.findViewById(R.id.amount);

                        Button btn = view.findViewById(R.id.btn_predict);
                        btn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ResultSet();//예측 결과 메소드
                            }
                        });
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
                        view2 = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.list_item_card_big_sales, parent, false);


                        Spinner s = (Spinner) view.findViewById(R.id.salesSpinner);
                        final TextView textView = (TextView) view.findViewById(R.id.salesFirstSmallLayoutTitle);
                        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view,
                                                       int position, long id) {

                                switch (String.valueOf(parent.getItemAtPosition(position))) {
                                    case "롯데마트 삼성점":
                                        shopWhere = "롯데마트 삼성점";

                                        break;
                                    case "GS수퍼마켓 강남대치점":
                                        shopWhere = "GS수퍼마켓 강남대치점";
                                        break;
                                }
                                textView.setText(shopWhere);
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {
                            }
                        });


                        return new RecyclerView.ViewHolder(view) {
                        };
                    }
                    case TYPE_CELL: {
                        view2.findViewById(R.id.salesFirstBigLayout).setVisibility(View.GONE);
                        view2.findViewById(R.id.salesSecondBigLayout).setVisibility(View.GONE);
                        view2.findViewById(R.id.salesThirdBigLayout).setVisibility(View.VISIBLE);
                        return new RecyclerView.ViewHolder(view2) {
                        };
                    }
                }

                return new RecyclerView.ViewHolder(view) {
                };
        }
        return null;
    }

    public void onRadioButtonClicked(View view) {
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

    public void progressBarChange(View view) {
        /*ProgressBar 수치 변경*/
        ProgressBar progressBar31 = (ProgressBar) view.findViewById(R.id.progressBar3_1);
        progressBar31.setProgress(76);
        ProgressBar progressBar32 = (ProgressBar) view.findViewById(R.id.progressBar3_2);
        progressBar32.setProgress(55);
        ProgressBar progressBar33 = (ProgressBar) view.findViewById(R.id.progressBar3_3);
        progressBar33.setProgress(69);
        ProgressBar progressBar34 = (ProgressBar) view.findViewById(R.id.progressBar3_4);
        progressBar34.setProgress(80);
        ProgressBar progressBar35 = (ProgressBar) view.findViewById(R.id.progressBar3_5);
        progressBar35.setProgress(93);

        /*ProgressBar 텍스트 변경*/
        TextView textView31 = (TextView) view.findViewById(R.id.index3_1);
        textView31.setText("76%");
        TextView textView32 = (TextView) view.findViewById(R.id.index3_2);
        textView32.setText("55%");
        TextView textView33 = (TextView) view.findViewById(R.id.index3_3);
        textView33.setText("69%");
        TextView textView34 = (TextView) view.findViewById(R.id.index3_4);
        textView34.setText("80%");
        TextView textView35 = (TextView) view.findViewById(R.id.index3_5);
        textView35.setText("93%");
    }

    //생산 부문 스피너
    public void SpinnerSet(View view) {
        Spinner ramenSpinner = view.findViewById(R.id.r_name);
        ArrayAdapter<CharSequence> ramenAdapter = ArrayAdapter.createFromResource(view.getContext(), R.array.ramen, android.R.layout.simple_spinner_item);
        ramenAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ramenSpinner.setAdapter(ramenAdapter);
        ramenSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                ((TextView) view).setTextColor(Color.BLACK);
                spinnerResult = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    public void RadioGet(View view) {
        rb1 = view.findViewById(R.id.rd_man);
        rb1.setChecked(true);
        radioResult = rb1.getText().toString();
        rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioResult = rb1.getText().toString();
            }
        });
        rb2 = view.findViewById(R.id.rd_time);
        rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioResult = rb2.getText().toString();
            }
        });
        rb3 = view.findViewById(R.id.rd_cost);
        rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioResult = rb3.getText().toString();
            }
        });
    }


    //생산부문 예측 결과
    public void ResultSet() {
        amountResult = editText.getText().toString();
        if(spinnerResult.equals("안성탕면")&&radioResult.equals("MAN")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 투입인원은");
            r_amount.setText("9.2명 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        } else if (spinnerResult.equals("안성탕면") && radioResult.equals("TIME")) {
            r_name.setText(spinnerResult + ", " + amountResult + "EA 생산시");
            r_param.setText("필요한 예상 생산시간은");
            r_amount.setText("12.6일 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");

        }else if(spinnerResult.equals("안성탕면")&&radioResult.equals("COST")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 재료비용은");
            r_amount.setText(" 314,100원 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }

        if(spinnerResult.equals("신라면")&&radioResult.equals("MAN")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 투입인원은");
            r_amount.setText("8.7명 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        } else if (spinnerResult.equals("신라면") && radioResult.equals("TIME")) {
            r_name.setText(spinnerResult + ", " + amountResult + "EA 생산시");
            r_param.setText("필요한 예상 생산시간은");
            r_amount.setText("10.4일 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }else if(spinnerResult.equals("신라면")&&radioResult.equals("COST")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 재료비용은");
            r_amount.setText(" 290,300원 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }

        if(spinnerResult.equals("너구리")&&radioResult.equals("MAN")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 투입인원은");
            r_amount.setText("12.1명 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        } else if (spinnerResult.equals("너구리") && radioResult.equals("TIME")) {
            r_name.setText(spinnerResult + ", " + amountResult + "EA 생산시");
            r_param.setText("필요한 예상 생산시간은");
            r_amount.setText("11.6일 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }else if(spinnerResult.equals("너구리")&&radioResult.equals("COST")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 재료비용은");
            r_amount.setText(" 344,200원 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }

        if(spinnerResult.equals("멸치칼국수라면")&&radioResult.equals("MAN")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 투입인원은");
            r_amount.setText("9.4명 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        } else if (spinnerResult.equals("멸치칼국수라면") && radioResult.equals("TIME")) {
            r_name.setText(spinnerResult + ", " + amountResult + "EA 생산시");
            r_param.setText("필요한 예상 생산시간은");
            r_amount.setText("10.9일 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }else if(spinnerResult.equals("멸치칼국수라면")&&radioResult.equals("COST")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 재료비용은");
            r_amount.setText(" 298,300원 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }

        if(spinnerResult.equals("사리곰탕")&&radioResult.equals("MAN")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 투입인원은");
            r_amount.setText("9.8명 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        } else if (spinnerResult.equals("사리곰탕") && radioResult.equals("TIME")) {
            r_name.setText(spinnerResult + ", " + amountResult + "EA 생산시");
            r_param.setText("필요한 예상 생산시간은");
            r_amount.setText("9.3일 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }else if(spinnerResult.equals("사리곰탕")&&radioResult.equals("COST")){
            r_name.setText(spinnerResult +", " + amountResult+"EA 생산시");
            r_param.setText("필요한 예상 재료비용은");
            r_amount.setText(" 310,700원 입니다.");
            r_amount.setTextSize(20);
            r_amount.setTypeface(r_amount.getTypeface(), Typeface.BOLD);
            r_amount.setTextColor(Color.BLUE);
            notify.setText("※예측값이므로 참고 용도로만 활용하기 바랍니다.");
        }
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