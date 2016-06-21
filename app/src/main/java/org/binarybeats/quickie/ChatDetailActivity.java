package org.binarybeats.quickie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import org.binarybeats.quickie.adapter.ChatDetailAdapter;
import org.binarybeats.quickie.model.ChatMessage;
import org.binarybeats.quickie.model.Status;
import org.binarybeats.quickie.model.UserType;

import java.util.ArrayList;

import hani.momanii.supernova_emoji_library.Actions.EmojIconActions;
import hani.momanii.supernova_emoji_library.Helper.EmojiconEditText;

public class ChatDetailActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    ArrayList<ChatMessage> mMessages;

    private EmojIconActions mEmojIconActions;
    private View mRootView;
    private EmojiconEditText mEmojiconEditText;
    private ImageView mEmojiButton;
    private ImageView mSendButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_detail);

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("@juanperez");
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRootView = findViewById(R.id.chat_rootview);
        mEmojiconEditText = (EmojiconEditText) findViewById(R.id.chat_edittext);
        mEmojiButton = (ImageView) findViewById(R.id.emojiButton);
        mSendButton = (ImageView) findViewById(R.id.send_button);

        initDummyMessages();

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new ChatDetailAdapter(mMessages, this);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.scrollToPosition(mMessages.size() - 1);

        mEmojIconActions = new EmojIconActions(this, mRootView, mEmojiconEditText, mEmojiButton);
        mEmojIconActions.ShowEmojIcon();
        mEmojIconActions.setKeyboardListener(new EmojIconActions.KeyboardListener() {
            @Override
            public void onKeyboardOpen() {
                mRecyclerView.scrollToPosition(mMessages.size() - 1);
            }

            @Override
            public void onKeyboardClose() {
                Log.d("TAG", "Keyboard Closed");
            }
        });

        mSendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMessages.add(new ChatMessage(mEmojiconEditText.getText().toString(), UserType.SELF, Status.DELIVERED));
                mAdapter.notifyDataSetChanged();
                mRecyclerView.scrollToPosition(mMessages.size() - 1);

                mEmojiconEditText.setText(null);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    private void initDummyMessages() {
        mMessages = new ArrayList<>();
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.SELF, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.OTHER, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.SELF, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.OTHER, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.SELF, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.SELF, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.SELF, Status.DELIVERED));
        mMessages.add(new ChatMessage("Hello, this is a message", UserType.OTHER, Status.DELIVERED));
    }
}
