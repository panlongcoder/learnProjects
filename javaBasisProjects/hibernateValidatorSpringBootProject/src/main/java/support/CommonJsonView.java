package support;

/**
 * json view type
 *
 * @author dragon
 * @since 2020/11/26
 */
public interface CommonJsonView {

    interface SecretView extends CommonJsonView.DetailView {
    }

    interface DetailView extends CommonJsonView.SimpleView {
    }

    interface SimpleView {
    }
}
