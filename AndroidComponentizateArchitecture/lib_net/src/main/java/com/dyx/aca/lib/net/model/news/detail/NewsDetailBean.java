package com.dyx.aca.lib.net.model.news.detail;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class NewsDetailBean {
    private boolean success;
    private DataEntity data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public static class DataEntity {
        private String id;
        private String author_id;
        private String tab;
        private String content;
        private String title;
        private String last_reply_at;
        private boolean good;
        private boolean top;
        private int reply_count;
        private int visit_count;
        private String create_at;
        private AuthorEntity author;
        private boolean is_collect;
        private List<RepliesEntity> replies;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthor_id() {
            return author_id;
        }

        public void setAuthor_id(String author_id) {
            this.author_id = author_id;
        }

        public String getTab() {
            return tab;
        }

        public void setTab(String tab) {
            this.tab = tab;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getLast_reply_at() {
            return last_reply_at;
        }

        public void setLast_reply_at(String last_reply_at) {
            this.last_reply_at = last_reply_at;
        }

        public boolean isGood() {
            return good;
        }

        public void setGood(boolean good) {
            this.good = good;
        }

        public boolean isTop() {
            return top;
        }

        public void setTop(boolean top) {
            this.top = top;
        }

        public int getReply_count() {
            return reply_count;
        }

        public void setReply_count(int reply_count) {
            this.reply_count = reply_count;
        }

        public int getVisit_count() {
            return visit_count;
        }

        public void setVisit_count(int visit_count) {
            this.visit_count = visit_count;
        }

        public String getCreate_at() {
            return create_at;
        }

        public void setCreate_at(String create_at) {
            this.create_at = create_at;
        }

        public AuthorEntity getAuthor() {
            return author;
        }

        public void setAuthor(AuthorEntity author) {
            this.author = author;
        }

        public boolean isIs_collect() {
            return is_collect;
        }

        public void setIs_collect(boolean is_collect) {
            this.is_collect = is_collect;
        }

        public List<RepliesEntity> getReplies() {
            return replies;
        }

        public void setReplies(List<RepliesEntity> replies) {
            this.replies = replies;
        }

        public static class AuthorEntity {
            private String loginname;
            private String avatar_url;

            public String getLoginname() {
                return loginname;
            }

            public void setLoginname(String loginname) {
                this.loginname = loginname;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }
        }

        public static class RepliesEntity {
            private String id;
            private AuthorEntityX author;
            private String content;
            private String create_at;
            private Object reply_id;
            private boolean is_uped;
            private List<String> ups;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public AuthorEntityX getAuthor() {
                return author;
            }

            public void setAuthor(AuthorEntityX author) {
                this.author = author;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_at() {
                return create_at;
            }

            public void setCreate_at(String create_at) {
                this.create_at = create_at;
            }

            public Object getReply_id() {
                return reply_id;
            }

            public void setReply_id(Object reply_id) {
                this.reply_id = reply_id;
            }

            public boolean isIs_uped() {
                return is_uped;
            }

            public void setIs_uped(boolean is_uped) {
                this.is_uped = is_uped;
            }

            public List<String> getUps() {
                return ups;
            }

            public void setUps(List<String> ups) {
                this.ups = ups;
            }

            public static class AuthorEntityX {
                
                private String loginname;
                private String avatar_url;

                public String getLoginname() {
                    return loginname;
                }

                public void setLoginname(String loginname) {
                    this.loginname = loginname;
                }

                public String getAvatar_url() {
                    return avatar_url;
                }

                public void setAvatar_url(String avatar_url) {
                    this.avatar_url = avatar_url;
                }
            }
        }
    }
}
