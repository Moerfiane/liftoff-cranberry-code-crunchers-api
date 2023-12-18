package org.launchcode.munchincrunch.models;

import jakarta.persistence.Entity;

@Entity
public class Category extends AbstractEntity {
        private String restaurant;

        public Category() {};
        public Category(restaurant) {
                this.username = username;
                this.pwHash = encoder.encode(password);
        }


    }
