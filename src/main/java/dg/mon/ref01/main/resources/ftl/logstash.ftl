input {  
     file {
       path => [${logfiles}]
       start_position => end
     }
}
filter{
    multiline {
        pattern => "${msplitregexs}"
        negate => true
        what => "previous"
    }
    mutate{
        add_field => {
            "ip" => "${hostIp}"
            "timestamp" => "%{@timestamp}"
            "index" => "alarm-%{+YYYY.MM.dd}"
            "topicId" => ""
        }
    }
<#list keyworditems as item>
    if "${item.sn}" in [message] {
        mutate{
            add_field => {
                keyword => "${item.sn}"
            }
            update => {
                "topicId" => "TOPIC_KEYWORD"
            }
        }
    }
</#list>

<#if nolog??>
    if "NOLOG" in [message] {
        mutate{
            add_field => {
                keyword => "NOLOG"
            }
            update => {
                "topicId" => "TOPIC_NOLOG"
            }
        }
    }
</#if>

<#list thresholditems as item>
    if "${item.sn}" in [message] {
        grok {
            match => ["message", "${item.keyReg}"]
        }
        mutate{
            add_field => {
                keyword => "${item.sn}"
            }
            update => {
                "topicId" => "TOPIC_THRESHOLD"
            }
        }
        mutate {
            convert => ["threshold", "float"]
        }
    }
</#list>
<#list continuousitems as item>
    if "${item.sn}" in [message] { 
        mutate{
            add_field => {
                keyword => "${item.sn}"
            }
            update => {
                "topicId" => "TOPIC_CONTINUOUS"
            }
        } 
    }
</#list>
    if [topicId] !~ "TOPIC" {
        drop{}
    }

    if "_grokparsefailure" in [tags] {
        drop{}
    }
}

output {
    kafka {
        bootstrap_servers => "9.123.130.151:9092,9.123.130.152:9092,9.123.130.153:9092"
        topic_id => "%{topicId}"
        compression_type => "none" # string (optional), one of ["none", "gzip", "snappy"],default: "none"
        partition_key_format => "%{host}"
    }
}