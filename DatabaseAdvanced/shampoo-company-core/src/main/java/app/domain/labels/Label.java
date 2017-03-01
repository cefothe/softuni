package app.domain.labels;

import java.io.Serializable;

/**
 * Created by cefothe on 10.12.16.
 */
public interface Label extends Serializable{
        long getId();

        void setId(long id);

        String getTitle();

        void setTitle(String title);

        String getSubTitle();

        void setSubTitle(String subTitle);

}
