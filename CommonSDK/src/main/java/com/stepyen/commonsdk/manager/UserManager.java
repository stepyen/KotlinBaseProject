package com.stepyen.commonsdk.manager;

import com.stepyen.commonsdk.constant.SPKey;
import com.stepyen.commonsdk.entity.User;

/**
 * date：2019-06-16
 * author：stepyen
 * description：
 */
public class UserManager {

    private static volatile UserManager instance;

    private User mUser;


    private UserManager() {
    }
    public static UserManager getInstance() {
        if (instance == null) {
            synchronized (UserManager.class) {
                if (instance == null) {
                    instance = new UserManager();
                }
            }
        }
        return instance;
    }


    public User getUser() {
        if (mUser == null) {
            User user = SPManager.getSP().getObject(SPKey.KEY_USER, User.class);
            if (user != null) {
                mUser = user;
            }
        }

        return mUser;
    }

    public void setUser(User user) {
        mUser = user;
        SPManager.getSP().putObject(SPKey.KEY_USER, user);
    }

    /**
     * 退出登录
     */
    public void loginOut() {
        SPManager.getSP().putObject(SPKey.KEY_USER, null);
    }


}
