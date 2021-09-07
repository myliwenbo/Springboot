package vip.xjdai.springbootmodbus.config;

import com.serotonin.modbus4j.ModbusMaster;
import com.serotonin.modbus4j.exception.ErrorResponseException;
import com.serotonin.modbus4j.exception.ModbusInitException;
import com.serotonin.modbus4j.exception.ModbusTransportException;
import com.serotonin.modbus4j.locator.BaseLocator;
import com.serotonin.modbus4j.msg.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: wingtech-boot-parent
 * @description: modbus读写工具类
 * @author: Ricardo.Liu
 * @create: 2020-05-08
 * @since: JDK 1.8
 **/
public class ModbusUtil
{

    //从机默认值
    private Integer slaveId = 1;

    @Autowired
    private AutoConfigurationImportModbus modbusConfig;

    /**
     * 测试
     *
     * @param args
     */
    public static void main(String[] args)
    {
        //			// 01测试
        //			Boolean v011 = readCoilStatus(1, 0);
        //			Boolean v012 = readCoilStatus(1, 1);
        //			Boolean v013 = readCoilStatus(1, 6);
        //			System.out.println("v011:" + v011);
        //			System.out.println("v012:" + v012);
        //			System.out.println("v013:" + v013);

        //			// 02测试
        //			Boolean v021 = readInputStatus(1, 0);
        //			Boolean v022 = readInputStatus(1, 1);
        //			Boolean v023 = readInputStatus(1, 2);
        //			System.out.println("v021:" + v021);
        //			System.out.println("v022:" + v022);
        //			System.out.println("v023:" + v023);

        //			// 03测试
        //			Number v031 = readHoldingRegister(1, 1, DataType.FOUR_BYTE_FLOAT);// 注意,float
        //			Number v032 = readHoldingRegister(1, 3, DataType.FOUR_BYTE_FLOAT);// 同上
        //			System.out.println("v031:" + v031);
        //			System.out.println("v032:" + v032);

        // 04测试
        //        Number v041 = readInputRegisters("1", 0, DataType.FOUR_BYTE_FLOAT);//
        //        Number v042 = readInputRegisters("1", 2, DataType.FOUR_BYTE_FLOAT);//
        //        System.out.println("v041:" + v041);
        //        System.out.println("v042:" + v042);
        // 批量读取
        //			batchRead();

    }

    /**
     * 读取[03 Holding Register类型 2x]模拟量数据
     *
     * @param slaveId
     *            slave Id
     * @param offset
     *            位置
     * @param dataType
     *            数据类型,来自com.serotonin.modbus4j.code.DataType
     * @return
     */
    public Number readHoldingRegister(int slaveId, int offset, int dataType,
                                      String ip) throws ModbusTransportException, ErrorResponseException, ModbusInitException
    {
        // 03 Holding Register类型数据读取
        BaseLocator< Number > loc       = BaseLocator.holdingRegister(slaveId, offset, dataType);
        ModbusMaster          tcpMaster = modbusConfig.getMaster(ip);
        return tcpMaster.getValue(loc);
    }

    /**
     * 读取[02 Input Status 1x]类型 开关数据
     *
     * @param slaveId
     * @param offset
     * @return
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
    public Boolean readInputStatus(int slaveId, int offset,
                                   String ip) throws ModbusTransportException, ErrorResponseException
    {
        // 02 Input Status
        BaseLocator< Boolean > loc       = BaseLocator.inputStatus(slaveId, offset);
        ModbusMaster           tcpMaster = modbusConfig.getMaster(ip);
        return tcpMaster.getValue(loc);
    }

    /**
     * 读取[04 Input Registers 3x]类型 模拟量数据
     *
     * @param slaveId
     *            slaveId
     * @param offset
     *            位置
     * @param dataType
     *            数据类型,来自com.serotonin.modbus4j.code.DataType
     * @return 返回结果
     * @throws ModbusTransportException
     *             异常
     * @throws ErrorResponseException
     *             异常
     * @throws ModbusInitException
     *             异常
     */
    public Number readInputRegisters(int slaveId, int offset, int dataType,
                                     String ip) throws ModbusTransportException, ErrorResponseException
    {
        // 04 Input Registers类型数据读取
        BaseLocator< Number > loc       = BaseLocator.inputRegister(slaveId, offset, dataType);
        ModbusMaster          tcpMaster = modbusConfig.getMaster(ip);
        return tcpMaster.getValue(loc);
    }

    /**
     * 批量读取使用方法
     *
     * @throws ModbusTransportException
     * @throws ErrorResponseException
     * @throws ModbusInitException
     */
    public void batchRead() throws ModbusTransportException, ErrorResponseException, ModbusInitException
    {

        //        BatchRead< Integer > batch = new BatchRead< Integer >();
        //
        //        batch.addLocator(0, BaseLocator.holdingRegister(1, 1, DataType.FOUR_BYTE_FLOAT));
        //        batch.addLocator(1, BaseLocator.inputStatus(1, 0));
        //
        //        ModbusMaster master = modbusConfig;
        //
        //        batch.setContiguousRequests(false);
        //        BatchResults< Integer > results = master.send(batch);
        //        System.out.println(results.getValue(0));
        //        System.out.println(results.getValue(1));
    }

    /**
     * 读取[01 Coil Status 0x]类型 开关数据
     *
     * @param slaveId
     *            slaveId
     * @param offset
     *            位置
     * @return 读取值
     */
    public Boolean readCoilStatus(int slaveId, int offset,
                                  String ip) throws ModbusTransportException, ErrorResponseException
    {
        // 读取 功能码 01 Coil 数据类型
        BaseLocator< Boolean > loc       = BaseLocator.coilStatus(slaveId, offset);
        ModbusMaster           tcpMaster = modbusConfig.getMaster(ip);
        return tcpMaster.getValue(loc);
    }

    public boolean[] readCoilStatus(String ip, int offset, int numberOfRegister) throws ModbusTransportException
    {

        ModbusMaster      master   = modbusConfig.getMaster(ip);
        ReadCoilsRequest  request  = new ReadCoilsRequest(slaveId, offset, numberOfRegister);
        ReadCoilsResponse response = (ReadCoilsResponse) master.send(request);
        boolean[]         booleans = response.getBooleanData();

        return valueRegroup(numberOfRegister, booleans);
    }

    /**
     * @Description: 读取外围设备输入的开关量，相当于功能码：02H-读离散输入状态
     * @Param: [ip, offset, numberOfRegister]
     * @return: boolean[]
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public boolean[] readInputStatus(String ip, int offset, int numberOfRegister) throws ModbusTransportException
    {

        ModbusMaster               master   = modbusConfig.getMaster(ip);
        ReadDiscreteInputsRequest  request  = new ReadDiscreteInputsRequest(slaveId, offset, numberOfRegister);
        ReadDiscreteInputsResponse response = (ReadDiscreteInputsResponse) master.send(request);
        boolean[]                  booleans = response.getBooleanData();

        return valueRegroup(numberOfRegister, booleans);
    }

    /**
     * @Description: 读取保持寄存器数据，相当于功能码：03H-读保持寄存器
     * @Param: [ip, offset, numberOfRegister]
     * @return: short[]
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public short[] readHoldingRegister(String ip, int offset, int numberOfRegister) throws ModbusTransportException
    {

        ModbusMaster                 master   = modbusConfig.getMaster(ip);
        ReadHoldingRegistersRequest  request  = new ReadHoldingRegistersRequest(slaveId, offset, numberOfRegister);
        ReadHoldingRegistersResponse response = (ReadHoldingRegistersResponse) master.send(request);
        return response.getShortData();
    }

    /**
     * @Description: 读取外围设备输入的数据，相当于功能码：04H-读输入寄存器
     * @Param: [ip, offset, numberOfRegister]
     * @return: short[]
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public short[] readInputRegisters(String ip, int offset, int numberOfRegister) throws ModbusTransportException
    {

        ModbusMaster               master   = modbusConfig.getMaster(ip);
        ReadInputRegistersRequest  request  = new ReadInputRegistersRequest(slaveId, offset, numberOfRegister);
        ReadInputRegistersResponse response = (ReadInputRegistersResponse) master.send(request);
        return response.getShortData();
    }

    /**
     * @Description: 写单个（线圈）开关量数据，相当于功能码：05H-写单个线圈
     * @Param: [ip, writeOffset, writeValue]
     * @return: boolean
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public boolean writeCoil(String ip, int writeOffset, boolean writeValue) throws ModbusTransportException
    {

        ModbusMaster      tcpMaster = modbusConfig.getMaster(ip);
        WriteCoilRequest  request   = new WriteCoilRequest(slaveId, writeOffset, writeValue);
        WriteCoilResponse response  = (WriteCoilResponse) tcpMaster.send(request);
        return !response.isException();
    }

    /**
     * @Description: 写多个开关量数据（线圈），相当于功能码：0FH-写多个线圈
     * @Param: [ip, startOffset, data]
     * @return: boolean
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public boolean writeCoils(String ip, int startOffset, boolean[] data) throws ModbusTransportException
    {

        ModbusMaster       tcpMaster = modbusConfig.getMaster(ip);
        WriteCoilsRequest  request   = new WriteCoilsRequest(slaveId, startOffset, data);
        WriteCoilsResponse response  = (WriteCoilsResponse) tcpMaster.send(request);
        return !response.isException();

    }

    /**
     * @Description: 写单个保持寄存器，相当于功能码：06H-写单个保持寄存器
     * @Param: [ip, writeOffset, writeValue]
     * @return: boolean
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public boolean writeHoldingRegister(String ip, int writeOffset,
                                        short writeValue) throws ModbusTransportException, ModbusInitException
    {

        ModbusMaster          tcpMaster = modbusConfig.getMaster(ip);
        WriteRegisterRequest  request   = new WriteRegisterRequest(slaveId, writeOffset, writeValue);
        WriteRegisterResponse response  = (WriteRegisterResponse) tcpMaster.send(request);
        return !response.isException();

    }

    /**
     * @Description: 写多个保持寄存器，相当于功能码：10H-写多个保持寄存器
     * @Param: [ip, startOffset, data]
     * @return: boolean
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    public boolean writeHoldingRegisters(String ip, int startOffset,
                                         short[] data) throws ModbusTransportException, ModbusInitException
    {

        ModbusMaster           tcpMaster = modbusConfig.getMaster(ip);
        WriteRegistersRequest  request   = new WriteRegistersRequest(slaveId, startOffset, data);
        WriteRegistersResponse response  = (WriteRegistersResponse) tcpMaster.send(request);
        return !response.isException();
    }

    /**
     * @Description: 转换工具，将Boolean转换成0，1
     * @Param: [numberOfBits, values]
     * @return: boolean[]
     * @throws:
     * @Author: Ricardo.Liu
     * @Date: 2020/5/8
     */
    private boolean[] valueRegroup(int numberOfBits, boolean[] values)
    {
        boolean[] bs   = new boolean[numberOfBits];
        int       temp = 1;
        for (boolean b : values) {
            bs[temp - 1] = b;
            temp++;
            if (temp > numberOfBits) {
                break;
            }
        }
        return bs;
    }
}