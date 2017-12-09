package hongzicong.rainbow.viewInterface;

import java.util.List;

import hongzicong.rainbow.model.ShareData;

/**
 * Created by DELL-PC on 2017/12/10.
 */

public interface ShareNowViewInterface extends MVPView {

    void refreshList();

    void setSwipeRefreshing(boolean refreshing);

}
