package global.coda.hospitalmanagement.constant;


// TODO: Auto-generated Javadoc
/**
 * The Class QueryConstant.
 *
 * @author VC
 */
public class QueryConstant {

	/** The Constant INSERT_USER. */
	public static final String INSERT_USER = "insert into t_user(username,email,password,fk_role_id) values(?,?,?,?)";
	
	/** The Constant INSERT_DOCTOR. */
	public static final String INSERT_DOCTOR = "insert into t_doctor(specialist,fk_user_id) values(?,?)";
	
	/** The Constant READ_DOCTOR. */
	public static final String READ_DOCTOR = "select pk_user_id,username,email,password,fk_role_id,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.pk_user_id=? and   t_user.is_active=? and t_doctor.is_active=?";
	
	/** The Constant READ_ALL_DOCTOR. */
	public static final String READ_ALL_DOCTOR = "select pk_user_id,username,email,password,fk_role_id,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.is_active=? and t_doctor.is_active=?";
	
	/** The Constant READ_DOCTOR_MASKED_DETAILS. */
	public static final String READ_DOCTOR_MASKED_DETAILS = "select username,specialist from t_user join t_doctor on t_user.pk_user_id = t_doctor.fk_user_id  where t_user.is_active=? and t_doctor.is_active=?";
	
	/** The Constant UPDATE_USER. */
	public static final String UPDATE_USER = "update t_user set username=?,email=?,password=? where pk_user_id=? and is_active=?";
	
	/** The Constant UPDATE_DOCTOR. */
	public static final String UPDATE_DOCTOR = "update t_doctor set specialist=? where fk_user_id=? and is_active=?";
	
	/** The Constant DELETE_USER. */
	public static final String DELETE_USER = "update t_user set is_active =? where pk_user_id=?";
	
	/** The Constant DELETE_DOCTOR. */
	public static final String DELETE_DOCTOR = "update t_doctor set is_active=? where fk_user_id=?";
	
	/** The Constant INSERT_PATIENT. */
	public static final String INSERT_PATIENT = "insert into t_patient(age,area,city,state,fk_user_id) values(?,?,?,?,?)";
	
	/** The Constant READ_PATIENT. */
	public static final String READ_PATIENT = "select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where  t_user.pk_user_id=? and   t_user.is_active =? and t_patient.is_active=?";
	
	/** The Constant READ_ALL_PATIENT. */
	public static final String READ_ALL_PATIENT = "select pk_user_id,username,email,password,fk_role_id,age,area,city,state from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where t_user.is_active =? and t_patient.is_active=?";
	
	/** The Constant READ_PATIENT_MASKED_DETAILS. */
	public static final String READ_PATIENT_MASKED_DETAILS = "select username,email,age from t_user join t_patient on t_user.pk_user_id = t_patient.fk_user_id where t_user.is_active =? and t_patient.is_active=?";
	
	/** The Constant UPDATE_PATIENT. */
	public static final String UPDATE_PATIENT = "update t_patient set age=?,area=?,city=?,state=? where fk_user_id=? and is_active=?";
	
	/** The Constant DELETE_PATIENT. */
	public static final String DELETE_PATIENT = "update t_patient set is_active=? where fk_user_id=?";
	
	/** The Constant READ_USER. */
	public static final String READ_USER = "select * from t_user where email=?  and is_active=?";
	
	/** The Constant READ_PATIENT_KEYS_PARTICULAR_DOCTOR. */
	public static final String READ_PATIENT_KEYS_PARTICULAR_DOCTOR = "select * from t_patient_has_doctor where fk_doctor_id=?";
	
	/** The Constant PATIENT_KEY. */
	public static final String PATIENT_KEY = "fk_patient_id";

	/**
	 * 
	 */
	public static final String READ_ALL_PATIENT_FOR_PARTICULAR_DOCTOR = "select * from t_patient_has_doctor join t_user on t_user.pk_user_id = t_patient_has_doctor.fk_patient_id  where t_patient_has_doctor.fk_doctor_id = ? and t_patient_has_doctor.is_active=1";

}
