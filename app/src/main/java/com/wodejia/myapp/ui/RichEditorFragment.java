package com.wodejia.myapp.ui;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;

import butterknife.BindView;
import jp.wasabeef.richeditor.RichEditor;

/**
 * 建议有时间自己用spanable写
 */
public class RichEditorFragment extends AppFragment {
    @BindView(R.id.editor)
    RichEditor mEditor;
    @BindView(R.id.preview)
    TextView mPreview;
    @BindView(R.id.action_undo)
    ImageButton action_undo;
    @BindView(R.id.action_redo)
    ImageButton action_redo;
    @BindView(R.id.action_bold)
    ImageButton action_bold;
    @BindView(R.id.action_italic)
    ImageButton action_italic;
    @BindView(R.id.action_subscript)
    ImageButton action_subscript;
    @BindView(R.id.action_superscript)
    ImageButton action_superscript;
    @BindView(R.id.action_strikethrough)
    ImageButton action_strikethrough;
    @BindView(R.id.action_underline)
    ImageButton action_underline;
    @BindView(R.id.action_heading1)
    ImageButton action_heading1;
    @BindView(R.id.action_heading2)
    ImageButton action_heading2;
    @BindView(R.id.action_heading3)
    ImageButton action_heading3;
    @BindView(R.id.action_heading4)
    ImageButton action_heading4;
    @BindView(R.id.action_heading5)
    ImageButton action_heading5;
    @BindView(R.id.action_heading6)
    ImageButton action_heading6;
    @BindView(R.id.action_txt_color)
    ImageButton action_txt_color;
    @BindView(R.id.action_bg_color)
    ImageButton action_bg_color;
//    @BindView(R.id.action_indent)
//    ImageButton action_indent;
    @BindView(R.id.action_outdent)
    ImageButton action_outdent;
    @BindView(R.id.action_align_left)
    ImageButton action_align_left;
    @BindView(R.id.action_align_center)
    ImageButton action_align_center;
    @BindView(R.id.action_align_right)
    ImageButton action_align_right;
//    @BindView(R.id.action_blockquote)
//    ImageButton action_blockquote;
    @BindView(R.id.action_insert_bullets)
    ImageButton action_insert_bullets;
    @BindView(R.id.action_insert_numbers)
    ImageButton action_insert_numbers;
    @BindView(R.id.action_insert_image)
    ImageButton action_insert_image;
    @BindView(R.id.action_insert_link)
    ImageButton action_insert_link;
//    @BindView(R.id.action_insert_checkbox)
//    ImageButton action_insert_checkbox;

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.rich_editor_fragment;
    }

    @Override
    protected void initView(View view) {
        mEditor.setEditorHeight(200);
        mEditor.setEditorFontSize(22);
        mEditor.setEditorFontColor(Color.RED);
        //mEditor.setEditorBackgroundColor(Color.BLUE);
        //mEditor.setBackgroundColor(Color.BLUE);
        //mEditor.setBackgroundResource(R.drawable.bg);
        mEditor.setPadding(10, 10, 10, 10);
        // mEditor.setBackground("https://raw.githubusercontent.com/wasabeef/art/master/chip.jpg");
        mEditor.setPlaceholder("Insert text here...");
        initListener();
    }

    protected void initListener() {

        mEditor.setOnTextChangeListener(new RichEditor.OnTextChangeListener() {
            @Override
            public void onTextChange(String text) {
                mPreview.setText(text);
            }
        });

        action_undo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.undo();
            }
        });

        action_redo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.redo();
            }
        });

        action_bold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setBold();
            }
        });

        action_italic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setItalic();
            }
        });

        action_subscript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setSubscript();
            }
        });

        action_superscript.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setSuperscript();
            }
        });

        action_strikethrough.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setStrikeThrough();
            }
        });

        action_underline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setUnderline();
            }
        });

        action_heading1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(1);
            }
        });

        action_heading2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(2);
            }
        });

        action_heading3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(3);
            }
        });

        action_heading4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(4);
            }
        });

        action_heading5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(5);
            }
        });

        action_heading6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setHeading(6);
            }
        });

        action_txt_color.setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override
            public void onClick(View v) {
                mEditor.setTextColor(isChanged ? Color.BLACK : Color.RED);
                isChanged = !isChanged;
            }
        });

        action_bg_color.setOnClickListener(new View.OnClickListener() {
            private boolean isChanged;

            @Override
            public void onClick(View v) {
                mEditor.setTextBackgroundColor(isChanged ? Color.TRANSPARENT : Color.YELLOW);
                isChanged = !isChanged;
            }
        });
//
//        action_indent.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mEditor.setIndent();
//            }
//        });

        action_outdent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setOutdent();
            }
        });

        action_align_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignLeft();
            }
        });

        action_align_center.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignCenter();
            }
        });

        action_align_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setAlignRight();
            }
        });
        //块引用
//        action_blockquote.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mEditor.setBlockquote();
//            }
//        });

        action_insert_bullets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setBullets();
            }
        });

        action_insert_numbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.setNumbers();
            }
        });

        action_insert_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.insertImage("http://7pn64c.com1.z0.glb.clouddn.com/qiniu_cloud_storage_1474256178?imageView2/0/w/1080/format/jpg", "dachshund");
            }
        });

        action_insert_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditor.insertLink("https://github.com/wasabeef", "wasabeef");
            }
        });

//        action_insert_checkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mEditor.insertTodo();
//            }
//        });
    }
}
