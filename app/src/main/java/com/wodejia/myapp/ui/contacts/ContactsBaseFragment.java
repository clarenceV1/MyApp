package com.wodejia.myapp.ui.contacts;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.clarence.libwidget.quicksidebar.DividerDecoration;
import com.example.clarence.libwidget.quicksidebar.OnQuickSideBarTouchListener;
import com.example.clarence.libwidget.quicksidebar.QuickSideBarTipsView;
import com.example.clarence.libwidget.quicksidebar.QuickSideBarView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.wodejia.myapp.R;
import com.wodejia.myapp.app.AppFragment;
import com.wodejia.myapp.data.contacts.ContactsBaseRequestDO;
import com.wodejia.myapp.data.contacts.ContactsMenuRequestDO;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;

public abstract class ContactsBaseFragment extends AppFragment implements OnQuickSideBarTouchListener {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.quickSideBarView)
    QuickSideBarView quickSideBarView;
    @BindView(R.id.quickSideBarTipsView)
    QuickSideBarTipsView quickSideBarTipsView;

    LinearLayoutManager layoutManager;
    ContactsBaseFragmentAdapter adapter;
    HashMap<String, Integer> letters = new HashMap<>();
    List<String> customLetters = new ArrayList<>();
    ContactsMenuRequestDO contactsRequestDO;
    public List<ContactsBaseRequestDO> data = new ArrayList<>();

    public abstract void loadData();

    public abstract ContactsBaseFragmentAdapter getAdapter();

    @Override
    public void initVariables() {
        getActivityComponent().inject(this);
    }

    @Override
    protected int getLayout() {
        return R.layout.contacts_fragment;
    }

    @Override
    public void initView(View view) {
        //不自定义则默认26个字母
        quickSideBarView.setLetters(customLetters);
        quickSideBarView.setOnQuickSideBarTouchListener(this);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        adapter = getAdapter();
        recyclerView.setAdapter(adapter);
        StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(adapter);
        recyclerView.addItemDecoration(headersDecor);
        recyclerView.addItemDecoration(new DividerDecoration(getContext()));

        getItent();
        loadData();
    }

    @Override
    public void onLetterChanged(String letter, int position, float y) {
        quickSideBarTipsView.setText(letter, position, y);
        //有此key则获取位置并滚动到该位置
        if (letters.containsKey(letter)) {
            int scrollTo = letters.get(letter);//扣去头部一个item
            moveToPosition(scrollTo);
        }
    }

    @Override
    public void onLetterTouching(boolean touching) {
        quickSideBarTipsView.setVisibility(touching ? View.VISIBLE : View.INVISIBLE);
    }

    public void getItent() {
        Bundle bundle = getArguments();
        if (bundle != null) {
            contactsRequestDO = (ContactsMenuRequestDO) bundle.getSerializable("ContactsRequestDO");
        }
    }

    private void moveToPosition(int n) {
        int firstItem = layoutManager.findFirstVisibleItemPosition();
        int lastItem = layoutManager.findLastVisibleItemPosition();
        if (firstItem <= n && n <= lastItem) {
            int top = recyclerView.getChildAt(n - firstItem).getTop();
            recyclerView.scrollBy(0, top);
        }
        recyclerView.scrollToPosition(n);
    }

    public void freshView(Collection<? extends ContactsBaseRequestDO> request) {
        if (request == null) {
            return;
        }
        data.clear();
        data.addAll(request);
        Collections.sort(data, new Comparator<ContactsBaseRequestDO>() {
            @Override
            public int compare(ContactsBaseRequestDO lhs, ContactsBaseRequestDO rhs) {
                if (lhs.getFirstLetter() == null || rhs.getFirstLetter() == null) {
                    return 0;
                }
                return lhs.getFirstLetter().compareTo(rhs.getFirstLetter());
            }
        });
        int position = 0;
        for (ContactsBaseRequestDO contactsBaseDO : data) {
            String letter = contactsBaseDO.getFirstLetter();
            //如果没有这个key则加入并把位置也加入
            if (letter != null && !letters.containsKey(letter)) {
                letters.put(letter, position);
                customLetters.add(letter);
            }
            position++;
        }
        adapter.addAll(data);
        quickSideBarView.setLetters(customLetters);
    }
}
