package net.nym.liteormuse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.Default;
import com.litesuits.orm.db.annotation.Ignore;
import com.litesuits.orm.db.annotation.NotNull;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.enums.AssignType;

import net.nym.ormlibrary.impl.NOrmImpl;
import net.nym.ormlibrary.operation.NOrm;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView text = (TextView) findViewById(R.id.text);
        NOrm nOrm = NOrmImpl.getInstance(this);

        User user = new User();
        user.setId(1);
        user.setName("wbushi");
        user.setLogin(false);
        nOrm.save(user);
        List<User> list = nOrm.query(User.class);
        text.setText(list.toString());

    }


    public class User{
        @PrimaryKey(AssignType.AUTO_INCREMENT)
        @Column("_id")
        private int id;
        @NotNull
        private String name;
        @Ignore
        private String password;
        @Default("true")
        private boolean isLogin;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isLogin() {
            return isLogin;
        }

        public void setLogin(boolean login) {
            isLogin = login;
        }

        @Override
        public String toString() {
            return String.format("id=%d,name=%s,isLogin=%s",id,name,String.valueOf(isLogin));
        }
    }
}
