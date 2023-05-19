# filterabletable-coroutine

```
# ❌❌❌ with Kotlin coroutine (kotest FunSpec) and logback fails
$ USE_LOGBACK=true ./gradlew test -i

...

MinimalTest > MyScannableTable works STANDARD_OUT
    15:40:35.771 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.sql.parser -- Reduced `NAME` = 'John'
    15:40:35.942 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.sql2rel -- Plan after converting SqlNode to RelNode
    LogicalProject(NAME=[$1])
      LogicalFilter(condition=[=($1, 'John')])
        LogicalTableScan(table=[[NAMES]])

    15:40:35.954 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:35.955 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:35.965 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary -- Rule Attempts Info for HepPlanner
    15:40:35.966 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary --
    Rules                                                                   Attempts           Time (us)
    * Total                                                                        0                   0

    15:40:35.966 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#10:LogicalFilter.NONE.[](input=HepRelVertex#9,condition==($0, 'John'))
    15:40:35.967 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#8:LogicalProject.NONE.[](input=HepRelVertex#7,exprs=[$1])
    15:40:35.967 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#1:LogicalTableScan.NONE.[](table=[NAMES])
    15:40:35.968 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:36.003 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.004 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ReduceExpressionsRule(Filter)] rels [#18]
    15:40:36.004 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#90: Apply rule [ReduceExpressionsRule(Filter)] to [rel#18:LogicalFilter]
    15:40:36.010 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#90 generated 0 successors.
    15:40:36.010 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.011 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [BindableTableScanRule] rels [#1]
    15:40:36.011 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#18: Apply rule [BindableTableScanRule] to [rel#1:LogicalTableScan]
    15:40:36.012 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#24 via BindableTableScanRule
    15:40:36.012 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#18: Full plan for rule input [rel#1:LogicalTableScan]:
    LogicalTableScan(table=[[NAMES]])

    15:40:36.013 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#18: Rule [BindableTableScanRule] produced [rel#24:BindableTableScan]
    15:40:36.013 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#18: Full plan for [rel#24:BindableTableScan]:
    BindableTableScan(table=[[NAMES]])

    15:40:36.017 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#18 generated 1 successors: [rel#24:BindableTableScan.BINDABLE.[](table=[NAMES])]
    15:40:36.017 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.017 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] rels [#1]
    15:40:36.017 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#20: Apply rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] to [rel#1:LogicalTableScan]
    15:40:36.020 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#26 via EnumerableTableScanRule(in:NONE,out:ENUMERABLE)
    15:40:36.020 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#20: Full plan for rule input [rel#1:LogicalTableScan]:
    LogicalTableScan(table=[[NAMES]])

    15:40:36.020 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#20: Rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] produced [rel#26:EnumerableTableScan]
    15:40:36.020 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#20: Full plan for [rel#26:EnumerableTableScan]:
    EnumerableTableScan(table=[[NAMES]])

    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#20 generated 1 successors: [rel#26:EnumerableTableScan.ENUMERABLE.[](table=[NAMES])]
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] rels [#16]
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#57: Apply rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] to [rel#16:LogicalProject]
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#28 via EnumerableProjectRule(in:NONE,out:ENUMERABLE)
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#57: Full plan for rule input [rel#16:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#57: Rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] produced [rel#28:EnumerableProject]
    15:40:36.021 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#57: Full plan for [rel#28:EnumerableProject]:
    EnumerableProject(NAME=[$1])
      EnumerableTableScan(subset=[rel#27:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.033 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#57 generated 1 successors: [rel#28:EnumerableProject.ENUMERABLE.[](input=RelSubset#27,exprs=[$1])]
    15:40:36.033 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.033 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [FilterProjectTransposeRule] rels [#18,#16]
    15:40:36.033 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79: Apply rule [FilterProjectTransposeRule] to [rel#18:LogicalFilter,rel#16:LogicalProject]
    15:40:36.033 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#31 via FilterProjectTransposeRule
    15:40:36.034 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79: Full plan for rule input [rel#18:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(subset=[rel#17:RelSubset#1.NONE.[]], NAME=[$1])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.034 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79: Full plan for rule input [rel#16:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.034 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79: Rule [FilterProjectTransposeRule] produced [rel#31:LogicalProject]
    15:40:36.034 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79: Full plan for [rel#31:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#79 generated 1 successors: [rel#31:LogicalProject.NONE.[](input=LogicalFilter#30,exprs=[$1])]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ReduceExpressionsRule(Filter)] rels [#30]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#163: Apply rule [ReduceExpressionsRule(Filter)] to [rel#30:LogicalFilter]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#163 generated 0 successors.
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] rels [#18]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#87: Apply rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] to [rel#18:LogicalFilter]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#34 via EnumerableFilterRule(in:NONE,out:ENUMERABLE)
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#87: Full plan for rule input [rel#18:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(subset=[rel#17:RelSubset#1.NONE.[]], NAME=[$1])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#87: Rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] produced [rel#34:EnumerableFilter]
    15:40:36.035 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#87: Full plan for [rel#34:EnumerableFilter]:
    EnumerableFilter(condition=[=($0, 'John')])
      EnumerableProject(subset=[rel#29:RelSubset#1.ENUMERABLE.[]], NAME=[$1])
        EnumerableTableScan(subset=[rel#27:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.046 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#87 generated 1 successors: [rel#34:EnumerableFilter.ENUMERABLE.[](input=RelSubset#29,condition==($0, 'John'))]
    15:40:36.046 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.046 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ExpandConversionRule] rels [#23]
    15:40:36.046 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#92: Apply rule [ExpandConversionRule] to [rel#23:AbstractConverter]
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#92 generated 0 successors.
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] rels [#24]
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#124: Apply rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] to [rel#24:BindableTableScan]
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#35 via EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#124: Full plan for rule input [rel#24:BindableTableScan]:
    BindableTableScan(table=[[NAMES]])

    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#124: Rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] produced [rel#35:EnumerableInterpreter]
    15:40:36.047 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#124: Full plan for [rel#35:EnumerableInterpreter]:
    EnumerableInterpreter
      BindableTableScan(table=[[NAMES]])

    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#124 generated 1 successors: [rel#35:EnumerableInterpreter.ENUMERABLE.[](input=BindableTableScan#24)]
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [MaterializedViewFilterScanRule] rels [#30,#1]
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#156: Apply rule [MaterializedViewFilterScanRule] to [rel#30:LogicalFilter,rel#1:LogicalTableScan]
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#156 generated 0 successors.
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] rels [#30]
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#160: Apply rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] to [rel#30:LogicalFilter]
    15:40:36.048 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#37 via EnumerableFilterRule(in:NONE,out:ENUMERABLE)
    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#160: Full plan for rule input [rel#30:LogicalFilter]:
    LogicalFilter(condition=[=($1, 'John')])
      LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#160: Rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] produced [rel#37:EnumerableFilter]
    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#160: Full plan for [rel#37:EnumerableFilter]:
    EnumerableFilter(condition=[=($1, 'John')])
      EnumerableTableScan(subset=[rel#27:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#160 generated 1 successors: [rel#37:EnumerableFilter.ENUMERABLE.[](input=RelSubset#27,condition==($1, 'John'))]
    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ProjectFilterTransposeRule] rels [#33,#30]
    15:40:36.049 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186: Apply rule [ProjectFilterTransposeRule] to [rel#33:LogicalProject,rel#30:LogicalFilter]
    15:40:36.052 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#40 via ProjectFilterTransposeRule
    15:40:36.052 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186: Full plan for rule input [rel#33:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(subset=[rel#32:RelSubset#3.NONE.[]], condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.052 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186: Full plan for rule input [rel#30:LogicalFilter]:
    LogicalFilter(condition=[=($1, 'John')])
      LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.052 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186: Rule [ProjectFilterTransposeRule] produced [rel#40:LogicalFilter]
    15:40:36.052 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186: Full plan for [rel#40:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#186 generated 1 successors: [rel#40:LogicalFilter.NONE.[](input=LogicalProject#39,condition==($0, 'John'))]
    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] rels [#33]
    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#199: Apply rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] to [rel#33:LogicalProject]
    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#42 via EnumerableProjectRule(in:NONE,out:ENUMERABLE)
    15:40:36.053 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#199: Full plan for rule input [rel#33:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(subset=[rel#32:RelSubset#3.NONE.[]], condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#15:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.054 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#199: Rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] produced [rel#42:EnumerableProject]
    15:40:36.054 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#199: Full plan for [rel#42:EnumerableProject]:
    EnumerableProject(NAME=[$1])
      EnumerableFilter(subset=[rel#38:RelSubset#3.ENUMERABLE.[]], condition=[=($1, 'John')])
        EnumerableTableScan(subset=[rel#27:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.054 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#199 generated 1 successors: [rel#42:EnumerableProject.ENUMERABLE.[](input=RelSubset#38,exprs=[$1])]
    15:40:36.054 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {130.0 rows, 216.0 cpu, 0.0 io}
    15:40:36.054 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary -- Rule Attempts Info for VolcanoPlanner
    15:40:36.055 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary --
    Rules                                                                   Attempts           Time (us)
    EnumerableProjectRule(in:NONE,out:ENUMERABLE)                                  2              13,332
    EnumerableFilterRule(in:NONE,out:ENUMERABLE)                                   2              11,956
    ReduceExpressionsRule(Filter)                                                  2               6,870
    BindableTableScanRule                                                          1               6,701
    ProjectFilterTransposeRule                                                     1               3,725
    EnumerableTableScanRule(in:NONE,out:ENUMERABLE)                                1               3,248
    FilterProjectTransposeRule                                                     1               1,597
    ExpandConversionRule                                                           1                 972
    EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)                          1                 963
    MaterializedViewFilterScanRule                                                 1                  88
    * Total                                                                       13              49,452

    15:40:36.059 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Cheapest plan:
    EnumerableProject(NAME=[$1]): rowcount = 15.0, cumulative cost = {130.0 rows, 216.0 cpu, 0.0 io}, id = 44
      EnumerableFilter(condition=[=($1, 'John')]): rowcount = 15.0, cumulative cost = {115.0 rows, 201.0 cpu, 0.0 io}, id = 43
        EnumerableTableScan(table=[[NAMES]]): rowcount = 100.0, cumulative cost = {100.0 rows, 101.0 cpu, 0.0 io}, id = 26

    15:40:36.060 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- Provenance:
    rel#44:EnumerableProject.ENUMERABLE.[](input=EnumerableFilter#43,exprs=[$1])
      direct
        rel#42:EnumerableProject.ENUMERABLE.[](input=RelSubset#38,exprs=[$1])
          call#199 rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)]
            rel#33:LogicalProject.NONE.[](input=RelSubset#32,exprs=[$1])
              call#79 rule [FilterProjectTransposeRule]
                rel#18:LogicalFilter.NONE.[](input=RelSubset#17,condition==($0, 'John'))
                  no parent
                rel#16:LogicalProject.NONE.[](input=RelSubset#15,exprs=[$1])
                  no parent
    rel#43:EnumerableFilter.ENUMERABLE.[](input=EnumerableTableScan#26,condition==($1, 'John'))
      direct
        rel#37:EnumerableFilter.ENUMERABLE.[](input=RelSubset#27,condition==($1, 'John'))
          call#160 rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)]
            rel#30:LogicalFilter.NONE.[](input=RelSubset#15,condition==($1, 'John'))
              call#79 rule [FilterProjectTransposeRule]
                rel#18 (see above)
                rel#16 (see above)
    rel#26:EnumerableTableScan.ENUMERABLE.[](table=[NAMES])
      call#20 rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)]
        rel#1:LogicalTableScan.NONE.[](table=[NAMES])
          no parent

    15:40:36.061 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#213: Apply rule [EnumerableFilterToCalcRule] to [rel#46:EnumerableFilter]
    15:40:36.068 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#213: Full plan for rule input [rel#46:EnumerableFilter]:
    EnumerableFilter(condition=[=($1, 'John')])
      EnumerableTableScan(table=[[NAMES]])

    15:40:36.068 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#213: Rule [EnumerableFilterToCalcRule] produced [rel#50:EnumerableCalc]
    15:40:36.068 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#213: Full plan for [rel#50:EnumerableCalc]:
    EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], proj#0..1=[{exprs}], $condition=[$t3])
      EnumerableTableScan(table=[[NAMES]])

    15:40:36.069 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#214: Apply rule [EnumerableProjectToCalcRule] to [rel#48:EnumerableProject]
    15:40:36.074 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#214: Full plan for rule input [rel#48:EnumerableProject]:
    EnumerableProject(NAME=[$1])
      EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], proj#0..1=[{exprs}], $condition=[$t3])
        EnumerableTableScan(table=[[NAMES]])

    15:40:36.074 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#214: Rule [EnumerableProjectToCalcRule] produced [rel#52:EnumerableCalc]
    15:40:36.074 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#214: Full plan for [rel#52:EnumerableCalc]:
    EnumerableCalc(expr#0..1=[{inputs}], NAME=[$t1])
      EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], proj#0..1=[{exprs}], $condition=[$t3])
        EnumerableTableScan(table=[[NAMES]])

    15:40:36.074 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#215: Apply rule [CalcMergeRule] to [rel#52:EnumerableCalc,rel#50:EnumerableCalc]
    15:40:36.074 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#215: Full plan for rule input [rel#52:EnumerableCalc]:
    EnumerableCalc(expr#0..1=[{inputs}], NAME=[$t1])
      EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], proj#0..1=[{exprs}], $condition=[$t3])
        EnumerableTableScan(table=[[NAMES]])

    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#215: Full plan for rule input [rel#50:EnumerableCalc]:
    EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], proj#0..1=[{exprs}], $condition=[$t3])
      EnumerableTableScan(table=[[NAMES]])

    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#215: Rule [CalcMergeRule] produced [rel#54:EnumerableCalc]
    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#215: Full plan for [rel#54:EnumerableCalc]:
    EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], NAME=[$t1], $condition=[$t3])
      EnumerableTableScan(table=[[NAMES]])

    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary -- Rule Attempts Info for HepPlanner
    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary --
    Rules                                                                   Attempts           Time (us)
    EnumerableProjectToCalcRule                                                    1               4,926
    EnumerableFilterToCalcRule                                                     1               3,285
    CalcMergeRule                                                                  1                 419
    * Total                                                                        3               8,630

    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#54:EnumerableCalc.ENUMERABLE.[](input=HepRelVertex#45,expr#0..1={inputs},expr#2='John':VARCHAR,expr#3==($t1, $t2),0=$t1,$condition=$t3)
    15:40:36.075 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#26:EnumerableTableScan.ENUMERABLE.[](table=[NAMES])
    15:40:36.079 [pool-1-thread-1 @coroutine#3] DEBUG org.apache.calcite.prepare.Prepare -- Plan after physical tweaks:
    EnumerableCalc(expr#0..1=[{inputs}], expr#2=['John':VARCHAR], expr#3=[=($t1, $t2)], NAME=[$t1], $condition=[$t3]): rowcount = 15.0, cumulative cost = {115.0 rows, 701.0 cpu, 0.0 io}, id = 54
      EnumerableTableScan(table=[[NAMES]]): rowcount = 100.0, cumulative cost = {100.0 rows, 101.0 cpu, 0.0 io}, id = 26

    name: John

MinimalTest > MyFilterableTable fails STANDARD_OUT
    15:40:36.155 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.sql.parser -- Reduced `NAME` = 'John'
    15:40:36.157 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.sql2rel -- Plan after converting SqlNode to RelNode
    LogicalProject(NAME=[$1])
      LogicalFilter(condition=[=($1, 'John')])
        LogicalTableScan(table=[[NAMES]])

    15:40:36.157 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:36.157 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:36.157 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary -- Rule Attempts Info for HepPlanner
    15:40:36.158 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.AbstractRelOptPlanner.rule_execution_summary --
    Rules                                                                   Attempts           Time (us)
    * Total                                                                        0                   0

    15:40:36.158 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#66:LogicalFilter.NONE.[](input=HepRelVertex#65,condition==($0, 'John'))
    15:40:36.158 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#64:LogicalProject.NONE.[](input=HepRelVertex#63,exprs=[$1])
    15:40:36.158 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- For final plan, using rel#57:LogicalTableScan.NONE.[](table=[NAMES])
    15:40:36.158 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.sql2rel -- Plan after trimming unused fields
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(table=[[NAMES]])

    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ReduceExpressionsRule(Filter)] rels [#74]
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#307: Apply rule [ReduceExpressionsRule(Filter)] to [rel#74:LogicalFilter]
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#307 generated 0 successors.
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [BindableTableScanRule] rels [#57]
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#235: Apply rule [BindableTableScanRule] to [rel#57:LogicalTableScan]
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#80 via BindableTableScanRule
    15:40:36.159 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#235: Full plan for rule input [rel#57:LogicalTableScan]:
    LogicalTableScan(table=[[NAMES]])

    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#235: Rule [BindableTableScanRule] produced [rel#80:BindableTableScan]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#235: Full plan for [rel#80:BindableTableScan]:
    BindableTableScan(table=[[NAMES]])

    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#235 generated 1 successors: [rel#80:BindableTableScan.BINDABLE.[](table=[NAMES])]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] rels [#57]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#237: Apply rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] to [rel#57:LogicalTableScan]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#82 via EnumerableTableScanRule(in:NONE,out:ENUMERABLE)
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#237: Full plan for rule input [rel#57:LogicalTableScan]:
    LogicalTableScan(table=[[NAMES]])

    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#237: Rule [EnumerableTableScanRule(in:NONE,out:ENUMERABLE)] produced [rel#82:EnumerableTableScan]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#237: Full plan for [rel#82:EnumerableTableScan]:
    EnumerableTableScan(table=[[NAMES]])

    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#237 generated 1 successors: [rel#82:EnumerableTableScan.ENUMERABLE.[](table=[NAMES])]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] rels [#72]
    15:40:36.160 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#274: Apply rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] to [rel#72:LogicalProject]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#84 via EnumerableProjectRule(in:NONE,out:ENUMERABLE)
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#274: Full plan for rule input [rel#72:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#274: Rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] produced [rel#84:EnumerableProject]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#274: Full plan for [rel#84:EnumerableProject]:
    EnumerableProject(NAME=[$1])
      EnumerableTableScan(subset=[rel#83:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#274 generated 1 successors: [rel#84:EnumerableProject.ENUMERABLE.[](input=RelSubset#83,exprs=[$1])]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [FilterProjectTransposeRule] rels [#74,#72]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296: Apply rule [FilterProjectTransposeRule] to [rel#74:LogicalFilter,rel#72:LogicalProject]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#87 via FilterProjectTransposeRule
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296: Full plan for rule input [rel#74:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(subset=[rel#73:RelSubset#1.NONE.[]], NAME=[$1])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296: Full plan for rule input [rel#72:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296: Rule [FilterProjectTransposeRule] produced [rel#87:LogicalProject]
    15:40:36.161 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296: Full plan for [rel#87:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#296 generated 1 successors: [rel#87:LogicalProject.NONE.[](input=LogicalFilter#86,exprs=[$1])]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ReduceExpressionsRule(Filter)] rels [#86]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#383: Apply rule [ReduceExpressionsRule(Filter)] to [rel#86:LogicalFilter]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#383 generated 0 successors.
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {inf}
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] rels [#74]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#304: Apply rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] to [rel#74:LogicalFilter]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#90 via EnumerableFilterRule(in:NONE,out:ENUMERABLE)
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#304: Full plan for rule input [rel#74:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(subset=[rel#73:RelSubset#1.NONE.[]], NAME=[$1])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#304: Rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] produced [rel#90:EnumerableFilter]
    15:40:36.162 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#304: Full plan for [rel#90:EnumerableFilter]:
    EnumerableFilter(condition=[=($0, 'John')])
      EnumerableProject(subset=[rel#85:RelSubset#1.ENUMERABLE.[]], NAME=[$1])
        EnumerableTableScan(subset=[rel#83:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#304 generated 1 successors: [rel#90:EnumerableFilter.ENUMERABLE.[](input=RelSubset#85,condition==($0, 'John'))]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ExpandConversionRule] rels [#79]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#309: Apply rule [ExpandConversionRule] to [rel#79:AbstractConverter]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#309 generated 0 successors.
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] rels [#80]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#342: Apply rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] to [rel#80:BindableTableScan]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#91 via EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#342: Full plan for rule input [rel#80:BindableTableScan]:
    BindableTableScan(table=[[NAMES]])

    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#342: Rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] produced [rel#91:EnumerableInterpreter]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#342: Full plan for [rel#91:EnumerableInterpreter]:
    EnumerableInterpreter
      BindableTableScan(table=[[NAMES]])

    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#342 generated 1 successors: [rel#91:EnumerableInterpreter.ENUMERABLE.[](input=BindableTableScan#80)]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [FilterTableScanRule] rels [#86,#57]
    15:40:36.163 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369: Apply rule [FilterTableScanRule] to [rel#86:LogicalFilter,rel#57:LogicalTableScan]
    15:40:36.165 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#93 via FilterTableScanRule
    15:40:36.165 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369: Full plan for rule input [rel#86:LogicalFilter]:
    LogicalFilter(condition=[=($1, 'John')])
      LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.165 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369: Full plan for rule input [rel#57:LogicalTableScan]:
    LogicalTableScan(table=[[NAMES]])

    15:40:36.165 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369: Rule [FilterTableScanRule] produced [rel#93:BindableTableScan]
    15:40:36.165 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369: Full plan for [rel#93:BindableTableScan]:
    BindableTableScan(table=[[NAMES]], filters=[[=($1, 'John')]])

    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#369 generated 1 successors: [rel#93:BindableTableScan.BINDABLE.[](table=[NAMES],filters=[=($1, 'John')])]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [MaterializedViewFilterScanRule] rels [#86,#57]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#376: Apply rule [MaterializedViewFilterScanRule] to [rel#86:LogicalFilter,rel#57:LogicalTableScan]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#376 generated 0 successors.
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] rels [#86]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#380: Apply rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] to [rel#86:LogicalFilter]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#95 via EnumerableFilterRule(in:NONE,out:ENUMERABLE)
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#380: Full plan for rule input [rel#86:LogicalFilter]:
    LogicalFilter(condition=[=($1, 'John')])
      LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#380: Rule [EnumerableFilterRule(in:NONE,out:ENUMERABLE)] produced [rel#95:EnumerableFilter]
    15:40:36.166 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#380: Full plan for [rel#95:EnumerableFilter]:
    EnumerableFilter(condition=[=($1, 'John')])
      EnumerableTableScan(subset=[rel#83:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#380 generated 1 successors: [rel#95:EnumerableFilter.ENUMERABLE.[](input=RelSubset#83,condition==($1, 'John'))]
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [ProjectFilterTransposeRule] rels [#89,#86]
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406: Apply rule [ProjectFilterTransposeRule] to [rel#89:LogicalProject,rel#86:LogicalFilter]
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#98 via ProjectFilterTransposeRule
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406: Full plan for rule input [rel#89:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(subset=[rel#88:RelSubset#3.NONE.[]], condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406: Full plan for rule input [rel#86:LogicalFilter]:
    LogicalFilter(condition=[=($1, 'John')])
      LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406: Rule [ProjectFilterTransposeRule] produced [rel#98:LogicalFilter]
    15:40:36.167 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406: Full plan for [rel#98:LogicalFilter]:
    LogicalFilter(condition=[=($0, 'John')])
      LogicalProject(NAME=[$1])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#406 generated 1 successors: [rel#98:LogicalFilter.NONE.[](input=LogicalProject#97,condition==($0, 'John'))]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {215.0 rows, 301.0 cpu, 0.0 io}
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] rels [#89]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#419: Apply rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] to [rel#89:LogicalProject]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#100 via EnumerableProjectRule(in:NONE,out:ENUMERABLE)
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#419: Full plan for rule input [rel#89:LogicalProject]:
    LogicalProject(NAME=[$1])
      LogicalFilter(subset=[rel#88:RelSubset#3.NONE.[]], condition=[=($1, 'John')])
        LogicalTableScan(subset=[rel#71:RelSubset#0.NONE.[]], table=[[NAMES]])

    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#419: Rule [EnumerableProjectRule(in:NONE,out:ENUMERABLE)] produced [rel#100:EnumerableProject]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#419: Full plan for [rel#100:EnumerableProject]:
    EnumerableProject(NAME=[$1])
      EnumerableFilter(subset=[rel#96:RelSubset#3.ENUMERABLE.[]], condition=[=($1, 'John')])
        EnumerableTableScan(subset=[rel#83:RelSubset#0.ENUMERABLE.[]], table=[[NAMES]])

    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#419 generated 1 successors: [rel#100:EnumerableProject.ENUMERABLE.[](input=RelSubset#96,exprs=[$1])]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Best cost before rule match: {130.0 rows, 216.0 cpu, 0.0 io}
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Pop match: rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] rels [#93]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#444: Apply rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] to [rel#93:BindableTableScan]
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- Transform to: rel#101 via EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)
    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#444: Full plan for rule input [rel#93:BindableTableScan]:
    BindableTableScan(table=[[NAMES]], filters=[[=($1, 'John')]])

    15:40:36.168 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#444: Rule [EnumerableInterpreterRule(in:BINDABLE,out:ENUMERABLE)] produced [rel#101:EnumerableInterpreter]
    15:40:36.169 [pool-1-thread-1 @coroutine#4] DEBUG org.apache.calcite.plan.RelOptPlanner -- call#444: Full plan for [rel#101:EnumerableInterpreter]:
    EnumerableInterpreter
      BindableTableScan(table=[[NAMES]], filters=[[=($1, 'John')]])


MinimalTest > MyFilterableTable fails FAILED
    java.lang.AssertionError: RelSubset [rel#78:RelSubset#2.ENUMERABLE.[]] has wrong best cost {130.0 rows, 216.0 cpu, 0.0 io}. Correct cost is {150.5 rows, 150.505 cpu, 0.0 io}
        at org.apache.calcite.util.Litmus.lambda$static$0(Litmus.java:31)
        at org.apache.calcite.plan.volcano.VolcanoPlanner.isValid(VolcanoPlanner.java:657)
        at org.apache.calcite.plan.volcano.VolcanoPlanner.ensureRegistered(VolcanoPlanner.java:619)
        at org.apache.calcite.plan.volcano.VolcanoRuleCall.transformTo(VolcanoRuleCall.java:144)
        at org.apache.calcite.plan.RelOptRuleCall.transformTo(RelOptRuleCall.java:273)
        at org.apache.calcite.plan.RelOptRuleCall.transformTo(RelOptRuleCall.java:288)
        at org.apache.calcite.rel.convert.ConverterRule.onMatch(ConverterRule.java:174)
        at org.apache.calcite.plan.volcano.VolcanoRuleCall.onMatch(VolcanoRuleCall.java:223)
        at org.apache.calcite.plan.volcano.IterativeRuleDriver.drive(IterativeRuleDriver.java:59)
        at org.apache.calcite.plan.volcano.VolcanoPlanner.findBestExp(VolcanoPlanner.java:523)
        at org.apache.calcite.tools.Programs.lambda$standard$3(Programs.java:276)
        at org.apache.calcite.tools.Programs$SequenceProgram.run(Programs.java:337)
        at org.apache.calcite.prepare.Prepare.optimize(Prepare.java:177)
        at org.apache.calcite.prepare.Prepare.prepareSql(Prepare.java:312)
        at org.apache.calcite.prepare.Prepare.prepareSql(Prepare.java:220)
        at org.apache.calcite.prepare.CalcitePrepareImpl.prepare2_(CalcitePrepareImpl.java:665)
        at org.apache.calcite.prepare.CalcitePrepareImpl.prepare_(CalcitePrepareImpl.java:519)
        at org.apache.calcite.prepare.CalcitePrepareImpl.prepareSql(CalcitePrepareImpl.java:487)
        at org.apache.calcite.jdbc.CalciteConnectionImpl.parseQuery(CalciteConnectionImpl.java:236)
        at org.apache.calcite.jdbc.CalciteMetaImpl.prepareAndExecute(CalciteMetaImpl.java:621)
        at org.apache.calcite.avatica.AvaticaConnection.prepareAndExecuteInternal(AvaticaConnection.java:677)
        at org.apache.calcite.avatica.AvaticaStatement.executeInternal(AvaticaStatement.java:157)
        at org.apache.calcite.avatica.AvaticaStatement.executeQuery(AvaticaStatement.java:228)
        at MinimalTest$1$2$1.invokeSuspend(MinimalTest.kt:62)
        at MinimalTest$1$2$1.invoke(MinimalTest.kt)
        at MinimalTest$1$2$1.invoke(MinimalTest.kt)
        at MinimalTest$1$2.invokeSuspend(MinimalTest.kt:66)
        at MinimalTest$1$2.invoke(MinimalTest.kt)
        at MinimalTest$1$2.invoke(MinimalTest.kt)

        Caused by:
        java.lang.AssertionError: RelSubset [rel#78:RelSubset#2.ENUMERABLE.[]] has wrong best cost {130.0 rows, 216.0 cpu, 0.0 io}. Correct cost is {150.5 rows, 150.505 cpu, 0.0 io}
            at org.apache.calcite.util.Litmus.lambda$static$0(Litmus.java:31)
            ... 28 more

Gradle Test Executor 21 finished executing tests.

> Task :test FAILED

...
```

```
# 🟢🟢🟢 with Kotlin coroutine (kotest FunSpec) and without logback works
$ USE_LOGBACK=false ./gradlew test -i

...

Successfully started process 'Gradle Test Executor 22'

MinimalTest > MyScannableTable works STANDARD_ERROR
    SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
    SLF4J: Defaulting to no-operation (NOP) logger implementation
    SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.

MinimalTest > MyScannableTable works STANDARD_OUT
    name: John

MinimalTest > MyFilterableTable fails STANDARD_OUT
    name: John

Gradle Test Executor 22 finished executing tests.

> Task :test

...

BUILD SUCCESSFUL in 4s

...
```
