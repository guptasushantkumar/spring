package com.app.nosql;

import javax.inject.Inject;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.data.hadoop.hbase.TableCallback;
import org.springframework.stereotype.Service;

@Service("hBaseService")
public class HBaseService {

	@Autowired
	private Configuration hbaseConfiguration;

	@Autowired
	private HbaseTemplate hbTemplate;

	// Table info
	final String tableName = "i60_sch08:an_json_sku_attributes";
	final String columnFamilyData = "cf";
	final String colFile = "file";
	final String rowNamePattern = "row";
	final String value = "report24.csv-";

	/**
	 * 
	 * @throws Exception
	 */

	public void run() throws Exception {
		// 1. create table
		 createTable();
		// 2. add data entry
		addData();
	}

	/**
	 * Creates HBase table
	 * 
	 * @throws Exception
	 */
	public void createTable() throws Exception {
		HBaseAdmin admin = new HBaseAdmin(hbaseConfiguration);
		//hbaseConfiguration.get
		if (admin.tableExists(tableName)) {
//			admin.disableTable(tableName);
//			admin.deleteTable(tableName);
			System.out.println("table found");
		}

		HTableDescriptor tableDes = new HTableDescriptor(tableName);
		HColumnDescriptor cf1 = new HColumnDescriptor(columnFamilyData);
		tableDes.addFamily(cf1);
		admin.createTable(tableDes);
	}

	/**
	 * Adds data entry for report.
	 */
	private void addData() {
		hbTemplate.execute(tableName, new TableCallback<Boolean>() {

			public Boolean doInTable(HTableInterface table) throws Throwable {
				System.out.println("Inserting");
				Put p = new Put(Bytes.toBytes("1167010"));
				p.add(Bytes.toBytes(columnFamilyData), Bytes.toBytes("name"),
						Bytes.toBytes("Sushant"));
				System.out.println("Going to put");
				table.put(p);
				System.out.println("Done");

				return new Boolean(true);
			}
		});
	}

	public static void main(String[] args) throws Exception {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring-hbase.xml");

		HBaseService hBaseService = (HBaseService) ctx.getBean("hBaseService");
		hBaseService.run();
	}
}