package com.example.duanwu.tao_taos;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class BeanDao {

        @Id(autoincrement = true)
        public Long  id;
        public String  name;
        public    String   set;
        private  String  image;
        @Generated(hash = 1910134739)
        public BeanDao(Long id, String name, String set, String image) {
            this.id = id;
            this.name = name;
            this.set = set;
            this.image = image;
        }
        @Generated(hash = 1438189893)
        public BeanDao() {
        }
        public Long getId() {
            return this.id;
        }
        public void setId(Long id) {
            this.id = id;
        }
        public String getName() {
            return this.name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getSet() {
            return this.set;
        }
        public void setSet(String set) {
            this.set = set;
        }
        public String getImage() {
            return this.image;
        }
        public void setImage(String image) {
            this.image = image;
        }


}
