package com.sds.study.sqliteapp;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by student on 2016-11-18.
 */
public class MemberItem extends LinearLayout{
    private Member member;
    TextView txt_member_id;
    TextView txt_password;
    TextView txt_id;

    public MemberItem(Context context,Member member) {
        super(context);
        this.member=member;
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.member_item,this);

        txt_member_id=(TextView) this.findViewById(R.id.txt_member_id);
        txt_password=(TextView) this.findViewById(R.id.txt_password);
        txt_id=(TextView) this.findViewById(R.id.txt_id);

        txt_member_id.setText(Integer.toString(member.getMember_id()));
        txt_id.setText(member.getId());
        txt_password.setText(member.getPassword());
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;

        txt_member_id.setText(Integer.toString(member.getMember_id()));
        txt_id.setText(member.getId());
        txt_password.setText(member.getPassword());
    }
}
