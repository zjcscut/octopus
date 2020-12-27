package cn.throwx.octopus.server.model.entity;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

public class UrlMapExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UrlMapExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNull() {
            addCriterion("short_url is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlIsNotNull() {
            addCriterion("short_url is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlEqualTo(String value) {
            addCriterion("short_url =", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotEqualTo(String value) {
            addCriterion("short_url <>", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThan(String value) {
            addCriterion("short_url >", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlGreaterThanOrEqualTo(String value) {
            addCriterion("short_url >=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThan(String value) {
            addCriterion("short_url <", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLessThanOrEqualTo(String value) {
            addCriterion("short_url <=", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlLike(String value) {
            addCriterion("short_url like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotLike(String value) {
            addCriterion("short_url not like", value, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlIn(List<String> values) {
            addCriterion("short_url in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotIn(List<String> values) {
            addCriterion("short_url not in", values, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlBetween(String value1, String value2) {
            addCriterion("short_url between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlNotBetween(String value1, String value2) {
            addCriterion("short_url not between", value1, value2, "shortUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNull() {
            addCriterion("long_url is null");
            return (Criteria) this;
        }

        public Criteria andLongUrlIsNotNull() {
            addCriterion("long_url is not null");
            return (Criteria) this;
        }

        public Criteria andLongUrlEqualTo(String value) {
            addCriterion("long_url =", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotEqualTo(String value) {
            addCriterion("long_url <>", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThan(String value) {
            addCriterion("long_url >", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlGreaterThanOrEqualTo(String value) {
            addCriterion("long_url >=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThan(String value) {
            addCriterion("long_url <", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLessThanOrEqualTo(String value) {
            addCriterion("long_url <=", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlLike(String value) {
            addCriterion("long_url like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotLike(String value) {
            addCriterion("long_url not like", value, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlIn(List<String> values) {
            addCriterion("long_url in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotIn(List<String> values) {
            addCriterion("long_url not in", values, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlBetween(String value1, String value2) {
            addCriterion("long_url between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andLongUrlNotBetween(String value1, String value2) {
            addCriterion("long_url not between", value1, value2, "longUrl");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIsNull() {
            addCriterion("short_url_digest is null");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIsNotNull() {
            addCriterion("short_url_digest is not null");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestEqualTo(String value) {
            addCriterion("short_url_digest =", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotEqualTo(String value) {
            addCriterion("short_url_digest <>", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestGreaterThan(String value) {
            addCriterion("short_url_digest >", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestGreaterThanOrEqualTo(String value) {
            addCriterion("short_url_digest >=", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLessThan(String value) {
            addCriterion("short_url_digest <", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLessThanOrEqualTo(String value) {
            addCriterion("short_url_digest <=", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestLike(String value) {
            addCriterion("short_url_digest like", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotLike(String value) {
            addCriterion("short_url_digest not like", value, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestIn(List<String> values) {
            addCriterion("short_url_digest in", values, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotIn(List<String> values) {
            addCriterion("short_url_digest not in", values, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestBetween(String value1, String value2) {
            addCriterion("short_url_digest between", value1, value2, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andShortUrlDigestNotBetween(String value1, String value2) {
            addCriterion("short_url_digest not between", value1, value2, "shortUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIsNull() {
            addCriterion("long_url_digest is null");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIsNotNull() {
            addCriterion("long_url_digest is not null");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestEqualTo(String value) {
            addCriterion("long_url_digest =", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotEqualTo(String value) {
            addCriterion("long_url_digest <>", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestGreaterThan(String value) {
            addCriterion("long_url_digest >", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestGreaterThanOrEqualTo(String value) {
            addCriterion("long_url_digest >=", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLessThan(String value) {
            addCriterion("long_url_digest <", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLessThanOrEqualTo(String value) {
            addCriterion("long_url_digest <=", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestLike(String value) {
            addCriterion("long_url_digest like", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotLike(String value) {
            addCriterion("long_url_digest not like", value, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestIn(List<String> values) {
            addCriterion("long_url_digest in", values, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotIn(List<String> values) {
            addCriterion("long_url_digest not in", values, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestBetween(String value1, String value2) {
            addCriterion("long_url_digest between", value1, value2, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andLongUrlDigestNotBetween(String value1, String value2) {
            addCriterion("long_url_digest not between", value1, value2, "longUrlDigest");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIsNull() {
            addCriterion("compression_code is null");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIsNotNull() {
            addCriterion("compression_code is not null");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeEqualTo(String value) {
            addCriterion("compression_code =", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotEqualTo(String value) {
            addCriterion("compression_code <>", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeGreaterThan(String value) {
            addCriterion("compression_code >", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeGreaterThanOrEqualTo(String value) {
            addCriterion("compression_code >=", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLessThan(String value) {
            addCriterion("compression_code <", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLessThanOrEqualTo(String value) {
            addCriterion("compression_code <=", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeLike(String value) {
            addCriterion("compression_code like", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotLike(String value) {
            addCriterion("compression_code not like", value, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeIn(List<String> values) {
            addCriterion("compression_code in", values, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotIn(List<String> values) {
            addCriterion("compression_code not in", values, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeBetween(String value1, String value2) {
            addCriterion("compression_code between", value1, value2, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andCompressionCodeNotBetween(String value1, String value2) {
            addCriterion("compression_code not between", value1, value2, "compressionCode");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andUrlStatusIsNull() {
            addCriterion("url_status is null");
            return (Criteria) this;
        }

        public Criteria andUrlStatusIsNotNull() {
            addCriterion("url_status is not null");
            return (Criteria) this;
        }

        public Criteria andUrlStatusEqualTo(Integer value) {
            addCriterion("url_status =", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusNotEqualTo(Integer value) {
            addCriterion("url_status <>", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusGreaterThan(Integer value) {
            addCriterion("url_status >", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("url_status >=", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusLessThan(Integer value) {
            addCriterion("url_status <", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusLessThanOrEqualTo(Integer value) {
            addCriterion("url_status <=", value, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusIn(List<Integer> values) {
            addCriterion("url_status in", values, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusNotIn(List<Integer> values) {
            addCriterion("url_status not in", values, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusBetween(Integer value1, Integer value2) {
            addCriterion("url_status between", value1, value2, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andUrlStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("url_status not between", value1, value2, "urlStatus");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(OffsetDateTime value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(OffsetDateTime value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(OffsetDateTime value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<OffsetDateTime> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNull() {
            addCriterion("edit_time is null");
            return (Criteria) this;
        }

        public Criteria andEditTimeIsNotNull() {
            addCriterion("edit_time is not null");
            return (Criteria) this;
        }

        public Criteria andEditTimeEqualTo(OffsetDateTime value) {
            addCriterion("edit_time =", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotEqualTo(OffsetDateTime value) {
            addCriterion("edit_time <>", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThan(OffsetDateTime value) {
            addCriterion("edit_time >", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeGreaterThanOrEqualTo(OffsetDateTime value) {
            addCriterion("edit_time >=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThan(OffsetDateTime value) {
            addCriterion("edit_time <", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeLessThanOrEqualTo(OffsetDateTime value) {
            addCriterion("edit_time <=", value, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeIn(List<OffsetDateTime> values) {
            addCriterion("edit_time in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotIn(List<OffsetDateTime> values) {
            addCriterion("edit_time not in", values, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("edit_time between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andEditTimeNotBetween(OffsetDateTime value1, OffsetDateTime value2) {
            addCriterion("edit_time not between", value1, value2, "editTime");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNull() {
            addCriterion("creator is null");
            return (Criteria) this;
        }

        public Criteria andCreatorIsNotNull() {
            addCriterion("creator is not null");
            return (Criteria) this;
        }

        public Criteria andCreatorEqualTo(String value) {
            addCriterion("creator =", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotEqualTo(String value) {
            addCriterion("creator <>", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThan(String value) {
            addCriterion("creator >", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorGreaterThanOrEqualTo(String value) {
            addCriterion("creator >=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThan(String value) {
            addCriterion("creator <", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLessThanOrEqualTo(String value) {
            addCriterion("creator <=", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorLike(String value) {
            addCriterion("creator like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotLike(String value) {
            addCriterion("creator not like", value, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorIn(List<String> values) {
            addCriterion("creator in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotIn(List<String> values) {
            addCriterion("creator not in", values, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorBetween(String value1, String value2) {
            addCriterion("creator between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andCreatorNotBetween(String value1, String value2) {
            addCriterion("creator not between", value1, value2, "creator");
            return (Criteria) this;
        }

        public Criteria andEditorIsNull() {
            addCriterion("editor is null");
            return (Criteria) this;
        }

        public Criteria andEditorIsNotNull() {
            addCriterion("editor is not null");
            return (Criteria) this;
        }

        public Criteria andEditorEqualTo(String value) {
            addCriterion("editor =", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotEqualTo(String value) {
            addCriterion("editor <>", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThan(String value) {
            addCriterion("editor >", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorGreaterThanOrEqualTo(String value) {
            addCriterion("editor >=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThan(String value) {
            addCriterion("editor <", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLessThanOrEqualTo(String value) {
            addCriterion("editor <=", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorLike(String value) {
            addCriterion("editor like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotLike(String value) {
            addCriterion("editor not like", value, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorIn(List<String> values) {
            addCriterion("editor in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotIn(List<String> values) {
            addCriterion("editor not in", values, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorBetween(String value1, String value2) {
            addCriterion("editor between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andEditorNotBetween(String value1, String value2) {
            addCriterion("editor not between", value1, value2, "editor");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNull() {
            addCriterion("deleted is null");
            return (Criteria) this;
        }

        public Criteria andDeletedIsNotNull() {
            addCriterion("deleted is not null");
            return (Criteria) this;
        }

        public Criteria andDeletedEqualTo(Integer value) {
            addCriterion("deleted =", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotEqualTo(Integer value) {
            addCriterion("deleted <>", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThan(Integer value) {
            addCriterion("deleted >", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleted >=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThan(Integer value) {
            addCriterion("deleted <", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedLessThanOrEqualTo(Integer value) {
            addCriterion("deleted <=", value, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedIn(List<Integer> values) {
            addCriterion("deleted in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotIn(List<Integer> values) {
            addCriterion("deleted not in", values, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedBetween(Integer value1, Integer value2) {
            addCriterion("deleted between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andDeletedNotBetween(Integer value1, Integer value2) {
            addCriterion("deleted not between", value1, value2, "deleted");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}