package co.nz.csoft.elasticsearch.enums;
    public enum SubscriptionType {
        MONTHLY("MONTHLY"),
        YEARLY("YEARLY"),
        TRANSACTION("TRANSACTION");
        private String subscriptionType;
        SubscriptionType(String subscriptionType)
        {
            this.subscriptionType=subscriptionType;
        }
        public String getValue()
        {
            return subscriptionType;
        }

    }
