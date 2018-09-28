package com.weibangbang.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.InputType;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.weibangbang.R;

/**
 * 创建者：zhangyunfei
 * 创建时间：2018/9/28 15:27
 * 功能描述：
 */
public class EditLayout extends FrameLayout {

    private EditText mEditText;

    private String hint, text;

    private int edit_inputType;

    private int mLines;

    public EditLayout(@NonNull Context context) {
        this(context, null);
    }

    public EditLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);

    }

    public EditLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.edit_layout,this,true);
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.EditLayout);
        if (array!=null){
            int anInt = array.getInt(R.styleable.EditLayout_bg_resource, R.drawable.edit_shape);
            setBackgroundResource(anInt);
            edit_inputType=array.getInt(R.styleable.EditLayout_et_inputType,InputType.TYPE_CLASS_TEXT);
            hint = array.getString(R.styleable.EditLayout_et_hint);
            text = array.getString(R.styleable.EditLayout_et_text);
            mLines = array.getInt(R.styleable.EditLayout_et_lines, 1);
            array.recycle();
        }
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mEditText = findViewById(R.id.content_et);
        mEditText.setBackground(null);
        mEditText.setTextSize(12);
        mEditText.setLines(mLines);
        mEditText.setInputType(edit_inputType);
        if (!TextUtils.isEmpty(hint)){
            mEditText.setHint(hint);
        }
        if (!TextUtils.isEmpty(text)){
            mEditText.setHint(text);
        }
    }

    public void setEditTextHint(String hint) {
        mEditText.setHint(hint);
    }

    public void setEditText(String text) {
        mEditText.setHint(text);
    }

    public String getEditText() {
        return mEditText.getText().toString();
    }
}
