package co.nz.csoft.elasticsearch.dto;

import java.util.List;
import java.util.Map;

public class RulesDto {

	private List<Policy> policies;

	public List<Policy> getPolicies() {
		return policies;
	}

	public void setPolicies(List<Policy> policies) {
		this.policies = policies;
	}
	@Override
    public String toString() {
        return "RulesDto{" +
                "policies=" + policies +
                '}';
    }

	public static class Policy {
		private String type;
		private String name;
		private Long id;
		private Condition condition;
		private Object result; // can hold String map or List depending on type
		private Dates dates;
		private ExtraData extraData;
		private Object conflict;
		public Object getConflict() {
		    return conflict;
		}

		public void setConflict(Object conflict) {
		    this.conflict = conflict;
		}

		// Getters and Setters
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Condition getCondition() {
			return condition;
		}

		public void setCondition(Condition condition) {
			this.condition = condition;
		}

		public Object getResult() {
			return result;
		}

		public void setResult(Object result) {
			this.result = result;
		}

		public Dates getDates() {
			return dates;
		}

		public void setDates(Dates dates) {
			this.dates = dates;
		}

		public ExtraData getExtraData() {
			return extraData;
		}

		public void setExtraData(ExtraData extraData) {
			this.extraData = extraData;
		}
		@Override
        public String toString() {
            return "Policy{" +
                    "type='" + type + '\'' +
                    ", name='" + name + '\'' +
                    ", id=" + id +
                    ", condition=" + condition +
                    ", result=" + result +
                    ", dates=" + dates +
                    ", extraData=" + extraData +
                    ", conflict=" + conflict +
                    '}';
        }

	}

	public static class Condition {
		  private Map<String, Object> data;
		  public Map<String, Object> getData() {
		        return data;
		    }

		    public void setData(Map<String, Object> data) {
		        this.data = data;
		    }

		    @Override
		    public String toString() {
		        return "Condition{" +
		                "data=" + data +
		                '}';
		    }
	}

	public static class Dates {
		private String start;
		private String end;

		public String getStart() {
			return start;
		}

		public void setStart(String start) {
			this.start = start;
		}

		public String getEnd() {
			return end;
		}

		public void setEnd(String end) {
			this.end = end;
		}
		 @Override
	        public String toString() {
	            return "Dates{" +
	                    "start='" + start + '\'' +
	                    ", end='" + end + '\'' +
	                    '}';
	        }
	}

	public static class ExtraData {
		private String cancellationDeadlineHour;

		public String getCancellationDeadlineHour() {
			return cancellationDeadlineHour;
		}

		public void setCancellationDeadlineHour(String cancellationDeadlineHour) {
			this.cancellationDeadlineHour = cancellationDeadlineHour;
		}
		@Override
        public String toString() {
            return "ExtraData{" +
                    "cancellationDeadlineHour='" + cancellationDeadlineHour + '\'' +
                    '}';
        }
	}

	// For cancellation result array
	public static class CancellationResult {
		private int Days_Before;
		private String Penalty_Type;
		private String Penalty_Value;
		private int Time_Before_Check_In;
		private String Time_Before_Check_In_Type;

		public int getDays_Before() {
			return Days_Before;
		}

		public void setDays_Before(int days_Before) {
			Days_Before = days_Before;
		}

		public String getPenalty_Type() {
			return Penalty_Type;
		}

		public void setPenalty_Type(String penalty_Type) {
			Penalty_Type = penalty_Type;
		}

		public String getPenalty_Value() {
			return Penalty_Value;
		}

		public void setPenalty_Value(String penalty_Value) {
			Penalty_Value = penalty_Value;
		}

		public int getTime_Before_Check_In() {
			return Time_Before_Check_In;
		}

		public void setTime_Before_Check_In(int time_Before_Check_In) {
			Time_Before_Check_In = time_Before_Check_In;
		}

		public String getTime_Before_Check_In_Type() {
			return Time_Before_Check_In_Type;
		}

		public void setTime_Before_Check_In_Type(String time_Before_Check_In_Type) {
			Time_Before_Check_In_Type = time_Before_Check_In_Type;
		}
		 @Override
	        public String toString() {
	            return "CancellationResult{" +
	                    "Days_Before=" + Days_Before +
	                    ", Penalty_Type='" + Penalty_Type + '\'' +
	                    ", Penalty_Value='" + Penalty_Value + '\'' +
	                    ", Time_Before_Check_In=" + Time_Before_Check_In +
	                    ", Time_Before_Check_In_Type='" + Time_Before_Check_In_Type + '\'' +
	                    '}';
	        }
	}

	// For general/property remark result
	public static class MessageResult {
		private String Title;
		private String Description;

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}
		@Override
        public String toString() {
            return "MessageResult{" +
                    "Title='" + Title + '\'' +
                    ", Description='" + Description + '\'' +
                    '}';
        }
	}

	// For immediate confirmation result
	public static class ImmediateResult {
		private boolean Is_Immediate;

		public boolean isIs_Immediate() {
			return Is_Immediate;
		}

		public void setIs_Immediate(boolean is_Immediate) {
			Is_Immediate = is_Immediate;
		}
		 @Override
	        public String toString() {
	            return "ImmediateResult{" +
	                    "Is_Immediate=" + Is_Immediate +
	                    '}';
	        }
	}
}
